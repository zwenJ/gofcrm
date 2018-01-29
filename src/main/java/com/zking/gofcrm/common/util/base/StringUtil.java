package com.zking.gofcrm.common.util.base;

import com.zking.gofcrm.authority.mapper.SysRoleMapper;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.common.util.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 说明：String字符串处理工具类
 *
 * @author Jzw
 * @date 2018/1/17 15:52
 */
public class StringUtil {

    /**
     * 判断该字符串是 NULL 值
     * 是NULL值 true
     * 不是NULL值 false
     * @param arg
     * @return
     */
    public static boolean isNull(String arg){
        return null == arg;
    }


    /**
     * 判断该字符串是 空 的 “”
     * "" 返回 true
     * !"" 返回 false
     * NULL 返回 true
     * @param arg
     * @return
     */
    public static boolean isEmpty(String arg) {
        if (!isNull(arg)) {
            if (isLength(arg)) {
                return "" == arg;
            }
            return false;
        }
        return true;
    }

    /**
     * 去掉字符串
     * 判断该字符串的 长度大于0
     * 大于0 true
     * 小于0 false
     * @param arg
     * @return
     */
    public static boolean isLength(String arg){
        if (!isNull(arg)){
            return arg.trim().length() > 0;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(!isEmpty(" "));
    }

}
