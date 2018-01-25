package com.zking.gofcrm.authority.shiro;

import com.zking.gofcrm.authority.model.SysAuthority;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.authority.service.IUserService;
import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.common.util.PageBean;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 说明：自定义 Shiro 权限认证、授权
 *
 * @author Jzw
 * @date 2018/1/17 10:56
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private SysUser sysUser;

    @Autowired
    private IUserService sysUserServices;

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取认证过的用户对象
        String userName = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("正在授权用户："+userName);

        //获取一个用户的具体信息
        sysUser = sysUserServices.loadUser(userName);

        //根据用户名查询用户的角色，权限
        ArrayList<String> roleList = new ArrayList<String>();
        ArrayList<String> authzList = new ArrayList<String>();
        //遍历角色
        for (SysRole sysRole : sysUser.getRoleList()) {
            //授权角色
            roleList.add(sysRole.getRoleAlias());
            //遍历权限
            for (SysAuthority sysAuthority : sysRole.getAuthzList()) {
                //如果不存在这个权限
                if (!authzList.contains(sysAuthority.getAuthText())) {
                    //授予子权限
                    authzList.add(sysAuthority.getAuthText());
                }
            }
        }

        //添加授权角色信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roleList);
        authorizationInfo.addStringPermissions(authzList);


        return authorizationInfo;
    }


    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        //获取用户令牌
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //从用户令牌中获取用户名
        String name = upToken.getUsername();

        //认证
        SimpleAuthenticationInfo auth = null;

       try{

           //通知服务层，进行数据库查询
           sysUser = sysUserServices.doLogin(name);

       } catch (Exception e){
         e.printStackTrace();
       }

        if (null != sysUser) {
            //令牌认证
            auth = new SimpleAuthenticationInfo(name,
                    sysUser.getUserPwd(),
                    this.getName());
        }

        return auth;
    }


}
