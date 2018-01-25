package com.zking.gofcrm.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/18 12:10
 */
@RequestMapping(value = "/to", method = RequestMethod.GET)
public class InputController extends ParentController {



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


}
