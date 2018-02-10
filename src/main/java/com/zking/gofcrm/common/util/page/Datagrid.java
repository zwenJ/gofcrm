package com.zking.gofcrm.common.util.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：EasyUI数据表格的分页数据格式定义
 *
 * @author Jzw
 * @date 2018/1/26 19:23
 */
public class Datagrid {

    /**
     * 查询的总记录数
     */
    private int total;

    /**
     * 查询的结果
     */
    private List rows = new ArrayList();


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

}
