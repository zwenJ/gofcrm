package com.zking.gofcrm.common.util.combo;

import org.springframework.stereotype.Component;

/**
 * 说明：EasyUI下拉框规则
 *
 * @author Jzw
 * @date 2018/2/2 15:59
 */
@Component
public class Combo {

    /**
     * 基础数据值名称绑定到该下拉列表框。
     */
    private String id;

    /**
     * 基础数据字段名称绑定到该下拉列表框。
     */
    private String text;

    /**
     * 是否选中该条值
     */
    private boolean selected = false;


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

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
