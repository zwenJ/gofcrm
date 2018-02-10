package com.zking.gofcrm.authority.util;

import java.util.List;

/**
 * 说明：用户权限Tree
 *
 * @author Jzw
 * @date 2018/1/22 13:15
 */
public class AuthTree {

    /**
     * 树的编号
     */
    private String id;

    /**
     * 树的标题
     */
    private String text;

    /**
     * 树的图标
     */
    private String iconCls;

    /**
     * 树对应的url
     */
    private String url;

    /**
     * 树是否被选中
     */
    private boolean checked;

    /**
     * 树的状态 open为打开 ，closed为关闭
     */
    private String state;

    /**
     * 树的子节点
     */
    private List<AuthTree> children;

    /**
     * 添加给树的自定义属性
     */
    private TreeProper attributes = new TreeProper();


    public TreeProper getAttributes() {
        return attributes;
    }

    public void setAttributes(TreeProper attributes) {
        this.attributes = attributes;
    }

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
