package com.zking.gofcrm.authority.mapper;

import com.zking.gofcrm.authority.model.SysAuthority;

import java.util.List;
import java.util.Map;

public interface SysAuthorityMapper {

    int deleteByPrimaryKey(String authId);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(String authId);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);


    List<SysAuthority> selectMap(Map<String, Object> map);
}