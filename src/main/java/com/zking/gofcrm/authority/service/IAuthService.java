package com.zking.gofcrm.authority.service;

import com.zking.gofcrm.authority.model.SysAuthority;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/21 20:38
 */
public interface IAuthService {


    // TODO: 2018/1/21 继续实现获取权限集合

    /**
     * 根据参数查询用户权限集合
     * userName
     * authParentId
     * authType
     *
     * @param map
     * @return
     */
    public List<SysAuthority> listAuth(Map<String, Object> map);


}
