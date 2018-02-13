package com.zking.gofcrm.authority.mapper;

import com.zking.gofcrm.authority.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    /**
     * 获取用户的集合
     * @param map
     * @return
     */
    List<SysUser> selectByPrimaryKey(Map<String, String[]> map);

    /**
     * 根据条件查询一个用户
     * @param map
     * @return
     */
    SysUser selectMapUser(Map<String, Object> map);

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    SysUser loginUser(SysUser sysUser);

    int updateByPrimaryKeySelective(SysUser record);

    int judgeAuthz(Map<String, Object> map);

}