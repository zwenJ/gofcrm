package com.zking.gofcrm.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 说明：统一处理控制器的所有错误信息
 *
 * @author Jzw
 * @date 2018/1/20 13:49
 */
@ControllerAdvice
public class ErrorController {

    private Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    public String captureError(Exception e){
        logger.error("错误", e);
        return "redirect:/html/error/error.html";
    }


}
