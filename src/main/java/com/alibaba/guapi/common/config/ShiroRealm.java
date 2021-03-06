package com.alibaba.guapi.common.config;

import com.alibaba.guapi.entity.User;
import com.alibaba.guapi.entity.UserRole;
import com.alibaba.guapi.mapper.UserRoleMapper;
import com.alibaba.guapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/15 10:14
 */
@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 获取认证信息
     *
     * @param authenticationToken token  就是登陆时候带过来的认证信息，如果认证通过，这些信息会被shiro缓存
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserInfoByUsername(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }
        // 认证的实体信息，可以使用用户名，也可以使用实体对象
        // 认证的证书，也就是认证的密码
        Object credentials = user.getPassword();
        // 盐，使用用户名做盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        String realmName = getName();
        return new SimpleAuthenticationInfo(user, credentials, credentialsSalt, realmName);
    }

    /**
     * 授权
     *
     * @param principalCollection 认证之后存在shiro中的用户信息
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 从principalCollection中获取登录信息，得到认证实体
        User user = (User) principalCollection.getPrimaryPrincipal();
        log.info(user.getUsername() + "授权开始");
        // 从得到的认证实体中获取用户的角色权限数据，或者通过查询数据库得到用户相应的角色、权限数据
        List<UserRole> userRoleList = userRoleMapper.findByUserId(user.getId());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        userRoleList.forEach(userRole -> {
            authorizationInfo.addRole(userRole.getRole().getRoleName());
            log.info(user.getUsername() + "具有" + userRole.getRole().getRoleName() + "角色");
        });
        // 将用户的角色、权限数据封装到 SimpleAuthorizationInfo 中，返回给Shiro
        return authorizationInfo;
    }
}
