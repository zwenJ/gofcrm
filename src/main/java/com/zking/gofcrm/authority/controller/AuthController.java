package com.zking.gofcrm.authority.controller;

import com.zking.gofcrm.authority.model.SysAuthority;
import com.zking.gofcrm.authority.service.IAuthService;
import com.zking.gofcrm.authority.util.AuthTree;
import com.zking.gofcrm.common.config.AuthType;
import com.zking.gofcrm.common.controller.ParentController;
import com.zking.gofcrm.common.service.IBaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/22 14:45
 */
@RequestMapping(value = "/auth", method = RequestMethod.POST)
public class AuthController extends ParentController {

    /**
     * 系统权限业务逻辑层的基础部分
     */
    @Resource(name = "AuthServiceImpl")
    private IBaseService<SysAuthority> authBaseService;

    /**
     * 系统权限业务逻辑层的附加部分
     */
    @Resource(name = "AuthServiceImpl")
    private IAuthService authService;


    /**
     * 根据 权限父编号 和 权限类型 来获取权限信息的一个集合
     * 并以JSON字符串格式返回
     * @param apId
     * @param at
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public List<SysAuthority> getAuth(@ModelAttribute("apId") String apId,
                                      @ModelAttribute("at") String at){
        return getAuthList(apId, at);
    }


    /**
     * 获取 权限信息 生成的一个 tree json数据结构
     * @param apId
     * @param at
     * @return
     */
    @RequestMapping("/tree")
    @ResponseBody
    public List<AuthTree> getAuthTree(@ModelAttribute("apId") String apId,
                                      @ModelAttribute("at") String at){

        List<SysAuthority> authList = getAuthList(apId, at);
        List<AuthTree> authTreeList = getAuthTreeList(authList, (String) subject.getPrincipal());

        return authTreeList;
    }


    /**
     * 前端的不同权限对应的不同视图，根据权限的 ID 在数据库中获取
     * @param authId
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getView(@ModelAttribute("authId") String authId){

        //通知业务逻辑层查询获取
        return authBaseService.loadObj(pageBean).getAuthUrl();
    }


    /**
     * 查询获取一个权限集合
     * @param apId
     * @param at
     * @return
     */
    private List<SysAuthority> getAuthList(String apId, String at){
        //配置查询参数
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", subject.getPrincipal());
        map.put("authType", at);
        map.put("authParentId", apId);

        return authService.listAuth(map);
    }

    /**
     * 将结果集合转换为AuthTree树结构
     * @param sysAuthorities
     * @param userName
     * @return
     */
    private List<AuthTree> getAuthTreeList(List<SysAuthority> sysAuthorities, String userName){
        //定义保存权限节点的集合
        List<AuthTree> authTreeList = new ArrayList<AuthTree>(sysAuthorities.size());
        //遍历设置相关参数
        for (SysAuthority sysAuthority : sysAuthorities) {
            AuthTree authTree = new AuthTree();
            authTree.setId(sysAuthority.getAuthId());
            authTree.setText(sysAuthority.getAuthText());
            authTree.setUrl(sysAuthority.getAuthUrl());
            authTree.setIconCls(sysAuthority.getAuthImage());
            //如果其是一个分支的根（文件夹）（表明其权限下还有子权限）
            if (sysAuthority.getAuthType().equalsIgnoreCase(AuthType.FOLDER+"")){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userName", userName);
                map.put("authParentId", sysAuthority.getAuthId());
                List<SysAuthority> sysAuthoritiesChild = authService.listAuth(map);
                //进行迭代操作
                authTree.setChildren(getAuthTreeList(sysAuthoritiesChild, userName));
                //文件夹默认不打开
                authTree.setState("closed");
            }
            authTreeList.add(authTree);
        }
        return authTreeList;
    }

}
