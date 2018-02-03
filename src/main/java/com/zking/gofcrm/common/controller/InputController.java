package com.zking.gofcrm.common.controller;

import com.zking.gofcrm.authority.model.SysRole;
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
            return "home/index";
        }

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
        if (!subject.hasRole("yguser")) {
            logger.debug("未登陆，或登陆失效");
            return "error";
        }
        logger.debug("已登录");
        return "success";
    }

}
