package com.zking.gofcrm.authority.controller;

import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.service.IRoleService;
import com.zking.gofcrm.authority.util.AuthTree;
import com.zking.gofcrm.common.controller.ParentController;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.page.Datagrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 说明：角色控制层
 *
 * @author Jzw
 * @date 2018/1/27 10:10
 */
@RestController
@RequestMapping(value = "/role", method = RequestMethod.POST)
public class RoleController extends ParentController {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(RoleController.class);


    /**
     * 角色的Service层
     */
    @Autowired
    private IRoleService roleBaseServiceImpl;



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


    /**
     * 添加用户角色
     * @param sysRole
     * @return
     */
    @RequestMapping("/addrole")
    public String addRole(SysRole sysRole){
        //不确定父权限编号
        String[] parentAuthIds = null;
        //保存权限编号的集合
        List<String> authIdList = new ArrayList<String>();

        //获取该角色拥有的权限
        String[] authTree = request.getParameterValues("authTreeList");

        //判断是否给角色添加权限
        if (null != authTree && authTree.length>0) {
            //将选中的权限编号添加到集合中
            for (String s : authTree) {
                authIdList.add(s);
            }

            //获取该角色拥有的不确定性的父权限（即该角色拥有该父权限的自权限，但是不全面）
            String parentAuthId = request.getParameter("parentAuthIds");
            if (null != parentAuthId && "" != parentAuthId){
                parentAuthIds = parentAuthId.split(",");
            }

            //将不确定性的父权限添加到集合中
            if (null != parentAuthIds && parentAuthIds.length > 0) {
                for (String authId : parentAuthIds) {
                    authIdList.add(authId);
                }
            }
        }

        //通知业务逻辑层
        boolean addObj = roleBaseServiceImpl.addObj(sysRole, authIdList);

        if (addObj) {
            return "success";
        }

        return "error";
    }


}
