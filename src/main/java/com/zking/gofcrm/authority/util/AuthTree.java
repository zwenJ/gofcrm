package com.zking.gofcrm.authority.util;

import java.util.List;

/**
 * 说明：用户权限Tree
 *
 * @author Jzw
 * @date 2018/1/22 13:15
 */
public class AuthTree {

    private String id;
    private String text;
    private String iconCls;
    private String url;
    private boolean checked;
    private String state;
    private List<AuthTree> children;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<AuthTree> getChildren() {
        return children;
    }

    public void setChildren(List<AuthTree> children) {
        this.children = children;
    }
}
