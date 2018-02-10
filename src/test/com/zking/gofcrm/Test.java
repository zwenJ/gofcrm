package com.zking.gofcrm;

import java.util.HashSet;
import java.util.Set;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/31 17:37
 */
public class Test {

    @org.junit.Test
    public void test() {

        String str = "2015,8,2016,3,2015,10,2017,5,2016,6,2017,5,2018,10";

        //使用split()函数根据逗号分割
        String[] strings = str.split(",");

        /**
         * 使用Set集合去重复
         */
        Set<String> stringSet = new HashSet<String>();
        for (int i = 0; i < strings.length; i+=2) {
            stringSet.add(strings[i]);
        }

        /**
         * 遍历Set集合，依次去比较数组中奇数位的年份是否相同
         * 相同则 加上数组[i+1]的数值
         */
        for (String s : stringSet) {
            //总金额
            int sum = 0;
            //遍历数组，比较年份
            for (int i = 0; i < strings.length; i+=2) {
                //年份相同，总金额+数组[i+1]位的值
                if (strings[i].equals(s)) {
                    sum += Integer.parseInt(strings[i+1]);
                }
            }
            //输出当前年份的总金额
            System.out.println(s + ":" + sum);
        }


    }

}
