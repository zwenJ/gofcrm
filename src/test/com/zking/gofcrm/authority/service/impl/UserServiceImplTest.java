package com.zking.gofcrm.authority.service.impl;

import com.zking.gofcrm.BaseCodeTest;
import com.zking.gofcrm.authority.mapper.SysRoleMapper;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.authority.service.IUserService;
import com.zking.gofcrm.common.util.page.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/2/2 12:36
 */
public class UserServiceImplTest extends BaseCodeTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private SysRoleMapper roleMapper;

    @Test
    public void listObj() throws Exception {

        PageBean pageBean = new PageBean();
        pageBean.setPaginate(true);
        pageBean.setCurPage(1);
        pageBean.setPageRecord(10);

        Map<String, Object> mapRole = new HashMap<String, Object>();
        for (SysUser sysUser : userService.listObj(pageBean)) {
            mapRole.put("userId", sysUser.getUserId());
            List<SysRole> sysRoles = roleMapper.selectByUserIdRole(mapRole);
            sysUser.setRoleList(sysRoles);
            System.out.println("用户："+sysUser.getUserName());
            for (SysRole sysRole : sysUser.getRoleList()) {
                System.out.println("对应的角色："+sysRole.getRoleName());
            }
        }

    }

}