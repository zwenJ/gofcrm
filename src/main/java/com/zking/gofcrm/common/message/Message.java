package com.zking.gofcrm.common.message;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述： 后台操作返回的消息
 * User: jzw
 * Date: 18-2-13
 * Time: 下午2:18
 */
@Component
public class Message implements Serializable {

    private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
    private String status;

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
        setDatas();
    }

    public Message(String type, String message, String status) {
        this.type = type;
        this.message = message;
        this.status = status;
        setDatas();
    }

    public Message(String type, String message, String status, String datas) {
        this.type = type;
        this.message = message;
        this.status = status;
        this.datas = datas;
        setDatas();
    }

    public Message(String type, String message, String status, boolean result, String datas) {
        this.type = type;
        this.message = message;
        this.status = status;
        this.result = result;
        this.datas = datas;
        setDatas();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatas() {
        return datas;
    }

    private void setDatas() {
        this.datas = SDF.format(new Date());
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
