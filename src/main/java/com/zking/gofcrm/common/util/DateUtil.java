package com.zking.gofcrm.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    /**
     * 将date格式转换格式输出
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        return simpleDateFormat.format(date);
    }


    /**
     * 获取一串 yyyyMMdd 格式的日期字符串
     * 返回Object[] 数组 第一个为字符串日期 第二个为Date对象
     * @return
     */
    public static Object[] getDateString(){
        Object[] objects = new Object[2];
        Date date = getDate();

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        objects[0] = simpleDateFormat.format(date);
        objects[1] = date;

        return objects;
    }


    public static Date getDate(){
        return new Date();
    }

}
