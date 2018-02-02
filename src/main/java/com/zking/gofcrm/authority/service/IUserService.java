package com.zking.gofcrm.authority.service;

import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.common.service.IBaseService;

/**
 * 说明：用户扩展服务层接口
 *
 * @author Jzw
 * @date 2018/1/20 11:58
 */
public interface IUserService extends IBaseService<SysUser> {

    /**
     * 用户登录
     * @param userName
     * @return
     */
    public SysUser doLogin(String userName);


    /**
     * 根据用户名查询一个用户信息
     * @param userName
     * @return
     */
    public SysUser loadUser(String userName);


}
