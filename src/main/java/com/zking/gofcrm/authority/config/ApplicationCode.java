package com.zking.gofcrm.authority.config;

/**
 * 描述： 用户模块执行过程中产生的 消息 和 状态
 * User: jzw
 * Date: 18-2-14
 * Time: 下午12:23
 */
public enum ApplicationCode {

    SUCCESS("操作成功", "100001"),
    ERROR("内部错误，请重试", "100002"),
    LOGIN_SUCCESS("用户登录成功", "100003"),
    LOGIN_ERROR("用户不存在或密码错误", "100004"),
    ROLE_SUCCESS("用户拥有权限", "100005"),
    ROLE_ERROR("用户权限不足", "100006");


    private String message, code;


    private ApplicationCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
