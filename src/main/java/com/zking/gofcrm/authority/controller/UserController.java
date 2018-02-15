package com.zking.gofcrm.authority.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.github.pagehelper.PageHelper;
import com.zking.gofcrm.authority.config.ApplicationCode;
import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.authority.service.IUserService;
import com.zking.gofcrm.common.controller.ParentController;
import com.zking.gofcrm.common.message.Message;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.page.Datagrid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scala.App;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/20 11:49
 */
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController extends ParentController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final String CODE_USER_LOGIN = "LOGIN_USER";

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Message login(@ModelAttribute("sysUser") SysUser sysUser) {
        logger.debug("用户登录："+sysUser);

        //通知登录的方法
        String info = loginUser(sysUser);
        //判断登录结果
        if ("error".equalsIgnoreCase(info)) {
            return new Message(CODE_USER_LOGIN, ApplicationCode.LOGIN_ERROR.getMessage(), ApplicationCode.LOGIN_ERROR.getCode());
        }
        //成功则重定向到进入首页的方法
        return new Message(CODE_USER_LOGIN, ApplicationCode.LOGIN_SUCCESS.getMessage(), ApplicationCode.LOGIN_SUCCESS.getCode());
    }


    /**
     * 返回 用户 的集合
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public Datagrid showUsers(Datagrid datagrid){

        //从数据库中查询
        List<SysUser> sysUsers = userService.listObj(pageBean);

        /**
         * 返会数据网格
         */
        datagrid.setTotal(pageBean.getTotalRecord());
        datagrid.setRows(sysUsers);

        return datagrid;
    }


    /**
     * 用户密码修改
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Message updateUser(){

        if (!isLogin()) {
            //如果没有登录
            return new Message("SysUser","请先登录");
        }
        // TODO: 18-2-13 通知业务逻辑层 实现修改用户密码的业务
        Message messageUser = userService.editObj(pageBean.getParameterMap());
        if (messageUser.getResult()) {
            subject.logout();
            messageUser.setMessage("修改密码成功，请重新登录！");
        }

        return messageUser;
    }


    /**
     * 用户登出
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){

        //执行用户登出的操作
        subject.logout();

        //用户登出
        return "redirect:/html/index.html";
    }



    /**
     * 用户进行登录
     * @param sysUser
     * @return
     */
    private String loginUser(SysUser sysUser){
        //如果已经登录
        if (isLogin()) {
            return "success";
        }
        //没有登录，调用Shiro认证
        return shiroLogin(sysUser);
    }

    /**
     * 进行Shiro认证
     * @param sysUser
     * @return
     */
    private String shiroLogin(SysUser sysUser){
        // 2 Shiro权限认证
        //获取用户令牌对象
        UsernamePasswordToken upToken = new UsernamePasswordToken();
        upToken.setUsername(sysUser.getUserName());
        upToken.setPassword(sysUser.getUserPwd().toCharArray());

        try{
            logger.debug("开始认证");
            subject.login(upToken);
        } catch (Exception e){
            logger.debug("认证失败，出现错误：", e);
            return "error";
        }

        logger.debug("认证通过");
        return "success";
    }


    /**
     * 判断用户是否已经登录
     * @return
     */
    private boolean isLogin(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return true;  //未发生改变，表明已经登录
        }
        return false;
    }

}
