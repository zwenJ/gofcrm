package com.zking.gofcrm.authority.util;

import com.zking.gofcrm.common.config.AuthType;

/**
 * 说明：树的自定义属性
 *
 * @author Jzw
 * @date 2018/1/26 20:04
 */
public class TreeProper {

    /**
     * 树类型
     */
    private String authType = AuthType.DOCUMENT+"";

    /**
     * 树对应的视图路径
     */
    private String authUrl;


    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}
