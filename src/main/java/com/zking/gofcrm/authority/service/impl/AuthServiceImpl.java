package com.zking.gofcrm.authority.service.impl;

import com.zking.gofcrm.authority.mapper.SysAuthorityMapper;
import com.zking.gofcrm.authority.model.SysAuthority;
import com.zking.gofcrm.authority.service.IAuthService;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 说明：权限Service层
 *
 * @author Jzw
 * @date 2018/1/21 20:35
 */
@Service(value = "AuthServiceImpl")
public class AuthServiceImpl implements IBaseService<SysAuthority>, IAuthService {


    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    /**
     * 根据参数查询用户权限集合
     * userName
     * authParentId
     * authType
     *
     * @param map
     * @return
     */
    public List<SysAuthority> listAuth(Map<String, Object> map) {
        List<SysAuthority> sysAuthorities = sysAuthorityMapper.selectMap(map);
        return sysAuthorities;
    }


    /**
     * 通用增加的方法，传入对象，返回true/false
     *
     * @param sysAuthority
     * @return
     */
    public boolean addObj(SysAuthority sysAuthority) {
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
     * @param sysAuthority
     * @return
     */
    public boolean editObj(SysAuthority sysAuthority) {
        return false;
    }

    /**
     * 加载（获取）一个对象，条件重PageBean的Map属性中获取，根据 K/V 式
     *
     * @param pageBean
     * @return
     */
    public SysAuthority loadObj(PageBean pageBean) {

        Map<String, String[]> parameterMap = pageBean.getParameterMap();

        SysAuthority sysAuthority = sysAuthorityMapper.selectByPrimaryKey(parameterMap.get("authId")[0]);

        return sysAuthority;
    }

    /**
     * 获取一个集合的对象，条件从PageBean的Map中获取，支持分页查询
     *
     * @param pageBean
     * @return
     */
    public List<SysAuthority> listObj(PageBean pageBean) {
        return null;
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
