package com.zking.gofcrm.authority.service;

import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.common.message.Message;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.page.PageBean;

import java.util.Map;

/**
 * 说明：用户扩展服务层接口
 *
 * @author Jzw
 * @date 2018/1/20 11:58
 */
public interface IUserService extends IBaseService<SysUser> {

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    public SysUser doLogin(SysUser sysUser);


    /**
     * 根据用户名查询一个用户信息
     * @param userName
     * @return
     */
    public SysUser loadUser(String userName);

    /**
     * 编辑（修改）方法，传入要修改的对象（必须保证要有主键(id)）
     *
     * @param stringMap
     * @return
     */
    Message editObj(Map<String, String[]> stringMap);

}
