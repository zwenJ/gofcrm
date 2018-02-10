package com.zking.gofcrm.authority.mapper;

import com.zking.gofcrm.authority.model.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    SysRole selectByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysRole record);


    /**
     * 查询一个角色的集合
     * @param map
     * @return
     */
    List<SysRole> selectMapAll(Map<String, Object> map);

    /**
     * 根据用户编号 查询 角色信息
     * @param map
     * @return
     */
    List<SysRole> selectByUserIdRole(Map<String, Object> map);


    /**
     * 角色 权限 联表查询
     * @param map
     * @return
     */
    List<SysRole> selectMapRA(Map<String, Object> map);


    /**
     * 新增角色对应的权限信息
     * @param map
     * @return
     */
    int insertRoleAuth(Map<String, String> map);

}