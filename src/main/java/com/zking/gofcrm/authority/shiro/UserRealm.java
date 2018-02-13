package com.zking.gofcrm.authority.shiro;

import com.zking.gofcrm.authority.model.SysAuthority;
import com.zking.gofcrm.authority.model.SysRole;
import com.zking.gofcrm.authority.model.SysUser;
import com.zking.gofcrm.authority.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private IUserService sysUserServices;

    /**
     * 用户的铭牌
     */
    public static final String APP_USER = "APP_USER_SHIRO";

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(UserRealm.APP_USER);

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

        //令牌转用户
        SysUser sysUser = tokenConversionUser((UsernamePasswordToken) authenticationToken);

        //数据库查询，是否可以登录
        sysUser = sysUserServices.doLogin(sysUser);
        if (null == sysUser) {
            return null;   //做异常处理，无法登录
        }

        //session保存
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(UserRealm.APP_USER, sysUser);

        //当前的Realm的name
        String realmName = this.getName();

        //获取Principal，可以是一个对象，但是该对想还是根据Principal的username和password来得到的
        Object principal = authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo(principal,
                sysUser.getUserPwd(),
                realmName);
    }


    /**
     * 将用户令牌转换为用户对象
     * @param token
     * @return
     */
    private SysUser tokenConversionUser(UsernamePasswordToken token){
        SysUser sysUser = new SysUser();
        sysUser.setUserName(token.getUsername());
        sysUser.setUserPwd(String.valueOf(token.getPassword()));
        return sysUser;
    }


}
