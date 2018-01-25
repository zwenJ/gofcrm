package com.zking.gofcrm.authority.controller;

import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.common.controller.ParentController;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/20 11:49
 */
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController extends ParentController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@ModelAttribute("sysUser") SysUser sysUser) {
        logger.debug("用户登录："+sysUser);

        /**
         *
         * 2 Shiro权限认证
         * 3 告知结果
         */
        // TODO: 2018/1/20  1 服务器验证

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

        //成功则重定向到进入首页的方法
        return "success";
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
        return "redirect:/html/index1.html";
    }



}