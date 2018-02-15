package com.zking.gofcrm.common.controller;

import com.zking.gofcrm.common.util.page.PageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

/**
 * 所有 Controller 的父类
 */
@Controller
public class ParentController {

    /**
     * 日志对象
     */
    private Logger  logger = LoggerFactory.getLogger(ParentController.class);

    //基本的request、response
    public HttpServletRequest request;
    public HttpServletResponse response;

    //授权、认证对象
    public Subject subject;

    //PageBean 查询、分页工具类
    public PageBean pageBean;

    /**
     * 对基础数据的初始化方法
     * @param model
     * @param request
     * @param response
     * @param pageBean
     */
    @ModelAttribute
    public void init(Model model,
                     HttpServletRequest request,
                     HttpServletResponse response,
                     PageBean pageBean) {

        this.request = request;
        this.response = response;
        this.subject = SecurityUtils.getSubject();
        pageBean.setRequest(request);
        this.pageBean = pageBean;

    }


}
