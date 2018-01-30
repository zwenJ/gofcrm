package com.zking.gofcrm.common.util.annotation;

import java.lang.annotation.*;

/**
 * 说明：自定义分页注解
 *
 * 1. Java中的注解概述
 *    首先要说明一个东西，注解这个东西绝对不是Spring为我们提供的，而是JDK带的，
 *    JDK自己也是有很多内置注解的，比如@override. 注解的功能其实就是为一些加
 *    了注解的类，方法等赋予特殊的含义,具体如何产生自定义的含义，其实就是注解处
 *    理器了,这是下一篇和大家讲的.
 *
 * 2. Java自带的元注解
 *     @Target      用于描述注解的使用范围,有一个枚举ElementType来指定,具体如下:
 *                     CONSTRUCTOR:用于描述构造器
 *                     FIELD:用于描述域
 *                     LOCAL_VARIABLE:用于描述局部变量
 *                     METHOD:用于描述方法
 *                     PACKAGE:用于描述包
 *                     PARAMETER:用于描述参数
 *                     TYPE:用于描述类、接口(包括注解类型) 或enum声明
 *
 *     @Retention   表示需要在什么级别保存该注释信息，用于描述注解的生命周期,
 *                  也是一个枚举RetentionPoicy来决定的，这个枚举我不列出来了，
 *                  包括这个注解的具体怎么决定注解的生命周期我也不多讲，因为根据
 *                  小弟这么多年使用的经验，都是填的RetentionPoicy.RUNTIME,填
 *                  这个值注解处理器才能通过反色拿到注解信息，实现自己的语义,所
 *                  以大家都填RetentionPoicy.RUNTIME就可以了，想扩展了解的自
 *                  行google..
 *                  范围：
 *                  RetentionPolicy.SOURCE	 只在源码时作用
 *                  RetentionPolicy.CLASS	 源码及编译期作用
 *                  RetentionPolicy.RUNTIME	 源码、编译期和运行时都起作用
 *
 *     @Documented  如果用javadoc生成文档时，想把注解也生成文档，就带这个。
 *
 *     @Inherited   @Inherited 元注解是一个标记注解，@Inherited阐述了某个被标
 *                  注的类型是被继承的。如果一个使用了@Inherited修饰的
 *                  annotation类型被用于一个class，则这个annotation将被用于
 *                  该class的子类。注意,@Inherited annotation类型是被标注过
 *                  的class的子类所继承。类并不从它所实现的接口继承annotation，
 *                  方法并不从它所重载的方法继承annotation。
 *                  简单说：当前注解能被继承。但不是指继承自定义注解，是指某个类
 *                  继承了一个使用了这个注解的类时，这个注解也被继承。
 * @author Jzw
 * @date 2018/1/30 9:40
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyPage {


    /**
     * 是否开启分页
     * @return
     */
    public boolean isPage() default false;


}
