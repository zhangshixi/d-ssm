package com.dssm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dssm.domain.manage.Admin;
import com.dssm.domain.manage.Permission;
import com.dssm.domain.manage.Role;
import com.dssm.service.manage.AdminService;
import com.mtoolkit.util.DateUtil;

public class ShiroJdbcRealm extends AuthorizingRealm {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String loginName = (String) principal.fromRealm(getName()).iterator().next();
		Admin loginAdmin = adminService.findAdminByLoginName(loginName);
		
		SimpleAuthorizationInfo authInfo = null;
		if (loginAdmin != null) {
			authInfo = new SimpleAuthorizationInfo();
			for (Role role : loginAdmin.getRoleList()) {
				authInfo.addRole(role.getCode());
				for (Permission permission : role.getPermissionList()) {
					authInfo.addStringPermission(permission.getCode());
				}
			}
		}
		
		return authInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		String loginName = token.getUsername();
		String password = String.valueOf(token.getPassword());

		Admin loginAdmin = adminService.findAdminByLoginName(loginName);
		
		if (loginAdmin == null) {
			throw new UnknownAccountException("Login admin [" + loginName + "] not exist" );
		} else if (!loginAdmin.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("Login admin [" + loginName + "] password error");
		} else if (loginAdmin.isLocked()) {
			throw new LockedAccountException("Login admin [" + loginName + "] is locked");
		} else {
			callbackOnLoginSuccess(loginAdmin.getId());
			return new SimpleAuthenticationInfo(loginAdmin, loginAdmin.getPassword(), getName());
		}
	}
	
	/**
	 * 登陆成功回调
	 */
	protected void callbackOnLoginSuccess(Long adminId) {
		String loginIp = SecurityUtils.getSubject().getSession().getHost();
		
		Admin loginAdmin = new Admin(adminId);
		loginAdmin.setLastLoginIp(loginIp);
		loginAdmin.setLastLoginTime(DateUtil.getCurrentTime());
		
		adminService.editAdmin(loginAdmin);
	}
	
}
