package com.zking.gofcrm.common.service;

import com.zking.gofcrm.authority.model.CrmIdSufUtil;

/**
 * 说明：表主键后缀
 *
 * @author Jzw
 * @date 2018/1/17 16:24
 */
public interface ICsfService {

    /**
     * 获取主键
     * @param tableName
     * @return
     */
    public String doIdSuf(String tableName);

}
