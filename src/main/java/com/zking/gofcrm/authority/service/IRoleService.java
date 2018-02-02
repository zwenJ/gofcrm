package com.zking.gofcrm.authority.service;

import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.common.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/29 10:25
 */
public interface IRoleService extends IBaseService<SysRole> {


    /**
     * 通用增加的方法，传入对象，返回true/false
     *
     * @param sysRole
     * @param authIds
     * @return
     */
    boolean addObj(SysRole sysRole, List<String> authIds);




}
