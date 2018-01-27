package com.zking.gofcrm.authority.controller;

import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.common.controller.ParentController;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.page.Datagrid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明：角色控制层
 *
 * @author Jzw
 * @date 2018/1/27 10:10
 */
@RestController
@RequestMapping(value = "/role", method = RequestMethod.POST)
public class RoleController extends ParentController {


    @Resource(name = "RoleServiceImpl")
    private IBaseService<SysRole> roleBaseServiceImpl;

    /**
     * 返回虽有角色（职位）信息
     * @return
     */
    @RequestMapping("/show")
    public Datagrid showRole(){

        //通知业务逻辑层查询
        List<SysRole> sysRoleList = roleBaseServiceImpl.listObj(pageBean);

        Datagrid datagrid = new Datagrid();
        datagrid.setTotal(pageBean.getTotalRecord());
        datagrid.setRows(sysRoleList);

        return datagrid;
    }


}
