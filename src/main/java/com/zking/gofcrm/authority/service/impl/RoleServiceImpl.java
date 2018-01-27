package com.zking.gofcrm.authority.service.impl;

import com.zking.gofcrm.authority.mapper.SysRoleMapper;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/27 10:12
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements IBaseService<SysRole> {


    @Autowired
    private SysRoleMapper sysRoleMapper;


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
}
