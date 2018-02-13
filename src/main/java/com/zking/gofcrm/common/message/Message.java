package com.zking.gofcrm.common.message;

import java.io.Serializable;

/**
 * 描述： 后台操作返回的消息
 * User: jzw
 * Date: 18-2-13
 * Time: 下午2:18
 */
public class Message implements Serializable {

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 处理结果
     */
    private boolean result = false;

    /**
     * 产生时间
     */
    private String datas;

    public Message() {

    }

    public Message(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public Message(String type, String message, Integer status) {
        this.type = type;
        this.message = message;
        this.status = status;
    }

    public Message(String type, String message, Integer status, String datas) {
        this.type = type;
        this.message = message;
        this.status = status;
        this.datas = datas;
    }

    public Message(String type, String message, Integer status, boolean result, String datas) {
        this.type = type;
        this.message = message;
        this.status = status;
        this.result = result;
        this.datas = datas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
