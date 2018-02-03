package com.zking.gofcrm.authority.service.impl;

import com.zking.gofcrm.BaseCodeTest;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.service.IRoleService;
import com.zking.gofcrm.common.util.page.PageBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 说明：测试Redis的缓存
 *
 * @author Jzw
 * @date 2018/2/3 16:57
 */
public class RoleServiceImplTest extends BaseCodeTest {


    @Autowired
    private IRoleService roleService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void listObj() throws Exception {

        PageBean pageBean = new PageBean();
        pageBean.setPaginate(false);
        for (SysRole sysRole : roleService.listObj(pageBean)) {
            System.out.println(sysRole);
        }

    }

}