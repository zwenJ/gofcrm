package com.zking.gofcrm.authority.service.impl;

import com.zking.gofcrm.authority.mapper.SysRoleMapper;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.service.IRoleService;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.service.ICsfService;
import com.zking.gofcrm.common.util.annotation.MyPage;
import com.zking.gofcrm.common.util.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/27 10:12
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private ICsfService csfService;


    /**
     * 通用增加的方法，传入对象，返回true/false
     *
     * @param sysRole
     * @return
     */
    public boolean addObj(SysRole sysRole) {
        return false;
    }

    /**
     * 通用删除方法，传入id，返回处理结果
     *
     * @param id
     * @return
     */
    public boolean delObj(Integer id) {
        return false;
    }

    /**
     * 通用编辑（修改）方法，传入要修改的对象（必须保证要有主键(id)）
     *
     * @param sysRole
     * @return
     */
    public boolean editObj(SysRole sysRole) {
        return false;
    }

    /**
     * 加载（获取）一个对象，条件重PageBean的Map属性中获取，根据 K/V 式
     *
     * @param pageBean
     * @return
     */
    public SysRole loadObj(PageBean pageBean) {
        return null;
    }

    /**
     * 获取一个集合的对象，条件从PageBean的Map中获取，支持分页查询
     *
     * @param pageBean
     * @return
     */
    // @MyPage(isPage = true) 我在切面中测试 自定义注解
    public List<SysRole> listObj(PageBean pageBean) {
        List<SysRole> sysRoleList = sysRoleMapper.selectMapAll(null);
        return sysRoleList;
    }

    /**
     * doAssignment  执行任务（工作）
     * 只需告诉我执行是否成功
     * 使用Map集合保存参数，目的是：执行任务无法保证参数究竟有多少！（参数是个未知数）
     *
     * @param map
     * @return
     */
    public boolean doAssignment(Map<String, Object> map) {
        return false;
    }

    /**
     * 通用增加的方法，传入对象，返回true/false
     *
     * @param sysRole
     * @param authIds
     * @return
     */
    public boolean addObj(SysRole sysRole, List<String> authIds) {

        //获取角色的编号
        String roleId = csfService.doIdSuf("ROLE");
        sysRole.setRoleId(roleId);
        sysRole.setRoleFlag(0);
        sysRole.setRoleAlias("CSUSER");

        //通知Mapping添加
        int insert = sysRoleMapper.insert(sysRole);
        if (insert > 0) {
            //添加角色成功
            //添加 角色相关连的权限
            if (null != authIds) {
                Map<String, String> mapRoleAuth = new HashMap<String, String>();
                mapRoleAuth.put("roleId", roleId);
                for (String authId : authIds) {
                    mapRoleAuth.put("authId", authId);
                    //通知Mapping层进行数据库插入操作
                    int insertRoleAuth = sysRoleMapper.insertRoleAuth(mapRoleAuth);
                    if (insertRoleAuth<0) {
                        //如果有一个失败的，则返回false该事务执行失败!
                        return false;
                    }
                }
                //只有添加成功才返回true
                return true;
            }
        }
        return false;
    }

}
