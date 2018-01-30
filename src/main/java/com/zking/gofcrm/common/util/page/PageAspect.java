package com.zking.gofcrm.common.util.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.gofcrm.common.util.annotation.MyPage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 说明：分页切面的配置
 *
 * @author Jzw
 * @date 2018/1/27 10:16
 */
@Component
@Aspect
public class PageAspect {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(PageAspect.class);

    /**
     * 定义一个切入点
     */
    @Pointcut("execution(* com.zking.gofcrm.*.service.impl..listObj(..))")
    public void joinPointcut(){}


    /**
     * 配置一个环绕通知
     * @param point
     * @return
     */
    @Around("joinPointcut()")
    public Object pageAround(ProceedingJoinPoint point) throws Throwable {
        logger.debug("分页的环绕通知---开始");

        Object[] args = null;
        Object proceed = null;
        PageBean pageBean = null;

//        Object target = point.getTarget();//获取切入点所在的对象
//        //获取切入点所在的方法
//        Method listObj = target.getClass().getDeclaredMethod("listObj", PageBean.class);
//        //判断该切入点是否存在 @MyPage 注解
//        if (listObj.isAnnotationPresent(MyPage.class)) {
//            logger.debug("测试：该切入点存在该注解");
//            //判断是否需要开启分页
//            if (listObj.getAnnotation(MyPage.class).isPage()) {
//                logger.debug("测试：该切入点需要分页");
//            }
//            else {
//                logger.debug("测试：该切入点不需要分页");
//            }
//        }
//        else {
//            logger.debug("测试：该切入点不存在该注解");
//        }

        //获取切入点方法的参数
        args = point.getArgs();

        //获取分页参数
        //获取参数的时候先判断该参数是否是 PageBean
        if (args[0] instanceof PageBean) {
            pageBean = (PageBean) args[0];
        }

        //询问是否需要分页
        if (null != pageBean && pageBean.isPaginate()) {
            // TODO: 2018/1/27 后续还要处理查询的参数
            //开始分页
            PageHelper.startPage(pageBean.getCurPage(), pageBean.getPageRecord());
        }

        /**
         * 环绕通知 前后 的分界线
         * proceed 可理解为切入点方法的返回参数
         */
        proceed = point.proceed(args);

        //依然询问是否需要分页
        if (null != pageBean && pageBean.isPaginate()) {
            //处理分页数据的后续
            PageInfo pageInfo = new PageInfo((List) proceed);
            pageBean.setTotalRecord((int) pageInfo.getTotal());
        }

        logger.debug("分页的环绕通知---结束");
        return proceed;
    }


}
