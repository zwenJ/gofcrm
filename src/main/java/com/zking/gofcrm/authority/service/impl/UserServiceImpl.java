package com.zking.gofcrm.authority.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.gofcrm.authority.mapper.SysRoleMapper;
import com.zking.gofcrm.authority.mapper.SysUserMapper;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.authority.service.IUserService;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.service.ICsfService;
import com.zking.gofcrm.common.util.page.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/17 14:11
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private ICsfService iCsfService;

    /**
     * 添加用户的方法
     * 通用增加的方法，传入对象，返回true/false
     *
     * @param sysUser
     * @return
     */
    public boolean addObj(SysUser sysUser) {
        /**
         * 新增一个用户：
         * 系统管理员和管理员都可以新增用户，但是均不能新增权限高于或等于自己的用户
         * 为其设置用户角色
         */
        //判断添加用户的 用户 是否具有 添加次用户角色 的权限
        Map<String, Object> mapJudeg = new HashMap<String, Object>();
        mapJudeg.put("userId", sysUser.getUserAddId());
        mapJudeg.put("roleId", sysUser.getRoleList().get(0));
        int judgeAuthz = sysUserMapper.judgeAuthz(mapJudeg);
        if (judgeAuthz>0) {
            //设置用户的编号
            sysUser.setUserId(iCsfService.doIdSuf("USER"));
            //执行添加的操作
            int insert = sysUserMapper.insert(sysUser);
            if (insert > 0) {
                return true;
            }
            logger.debug("添加操作失败，具体看LOG");
        }
        logger.debug("添加用户失败，因为操作用户没有权限！");

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
     * @param sysUser
     * @return
     */
    public boolean editObj(SysUser sysUser) {
        return false;
    }

    /**
     * 加载（获取）一个对象，条件重PageBean的Map属性中获取，根据 K/V 式
     *
     * @param pageBean
     * @return
     */
    public SysUser loadObj(PageBean pageBean) {
        return null;
    }

    /**
     * 获取一个集合的对象，条件从PageBean的Map中获取，支持分页查询
     *
     * @param pageBean
     * @return
     */
    public List<SysUser> listObj(PageBean pageBean) {

        List<SysUser> sysUserList = sysUserMapper.selectByPrimaryKey(null);

        //查询每个用户的角色
        Map<String, Object> mapRole = new HashMap<String, Object>();
        for (SysUser sysUser : sysUserList) {
            mapRole.put("userId", sysUser.getUserId());
            List<SysRole> sysRoleList = roleMapper.selectByUserIdRole(mapRole);
            sysUser.setRoleList(sysRoleList);
        }

        return sysUserList;
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
     * 用户登录
     *
     * @param userName
     * @return
     */
    public SysUser doLogin(String userName) {
        return sysUserMapper.loginUser(userName);
    }

    /**
     * 根据用户名查询一个用户信息
     *
     * @param userName
     * @return
     */
    public SysUser loadUser(String userName) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userName);

        return sysUserMapper.selectMapUser(map);
    }



}
