package com.zking.gofcrm.common.controller;

import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.authority.shiro.UserRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/18 12:10
 */
@RequestMapping(value = "/to", method = RequestMethod.GET)
public class InputController extends ParentController {

    private Logger logger = LoggerFactory.getLogger(InputController.class);

    /**
     * 进入首页的入口 /WEB-INF/view/index1.jsp
     * @return
     */
    @RequestMapping("/home")
    public String toHome(){

        /**
         * 进入首页先判断是否已经登陆,即判断是否已具有员工的权限
         */
        if (subject.hasRole("yguser")) {
            logger.debug("具备员工的角色，正在进入首页");
            return "home/index";
        }

        logger.debug("不具备员工的角色，无法进入首页");
        //重定向回登陆页面
        return "redirect:/html/index.html";
    }


    /**
     * 获取相应的视图资源
     * @param dir
     * @param view
     * @param model
     * @return
     */
    @RequestMapping("/view/{dir}/{view}")
    public String toView(@PathVariable("dir") String dir,
                         @PathVariable("view") String view,
                         Model model) {

        //权限认证
        if (!subject.hasRole("yguser")) {
            return "redirect:/html/index.html";
        }

        if ("addoredit_role".equalsIgnoreCase(view)){
            model.addAttribute("sysRole",new SysRole());
        }

        if ("user_list".equalsIgnoreCase(view)) {
            model.addAttribute("SysUser", new SysUser());
        }

        if ("user_personal_center".equalsIgnoreCase(view)) {
            //进入用户个人中心
            request.setAttribute("SysUser", subject.getSession().getAttribute(UserRealm.APP_USER));
        }

        return dir+"/"+view;
    }


    /**
     * 用于确定用户是否已经登陆
     * @param id
     * @return
     */
    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    @ResponseBody
    public String isUserLogin(@ModelAttribute("id") String id){
        logger.debug("请求判断用户是否登陆",id);
        if (!subject.isAuthenticated()) {
            logger.debug("未登陆，或登陆失效");
            return "error";
        }
        logger.debug("已登录");
        return "success";
    }

}
