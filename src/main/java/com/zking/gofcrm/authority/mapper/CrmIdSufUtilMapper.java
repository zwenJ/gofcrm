package com.zking.gofcrm.authority.mapper;

import com.zking.gofcrm.authority.model.CrmIdSufUtil;

public interface CrmIdSufUtilMapper {

    //插入数据
    int insert(CrmIdSufUtil record);

    //获取查询数据
    CrmIdSufUtil selectByPrimaryKey(String tableName);

    //修改数据
    int updateByPrimaryKeySelective(CrmIdSufUtil record);

}