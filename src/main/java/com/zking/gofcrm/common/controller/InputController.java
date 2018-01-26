package com.zking.gofcrm.common.controller;

import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping("/view/{dir}/{view}")
    public String toView(@PathVariable("dir") String dir,
                         @PathVariable("view") String view) {

        //权限认证
        if (!subject.hasRole("yguser")) {
            return "redirect:/html/index.html";
        }

        return dir+"/"+view;
    }


}
