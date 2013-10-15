package com.dssm.shiro;

import java.util.List;

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

import com.dssm.domain.security.Admin;
import com.dssm.domain.security.Permission;
import com.dssm.domain.security.Role;
import com.dssm.service.security.AdminService;
import com.dssm.service.security.PermissionService;
import com.dssm.service.security.RoleService;
import com.mtoolkit.util.DateUtil;

public class ShiroJdbcRealm extends AuthorizingRealm {
	
	@Autowired
	private AdminService 	   adminService;
	@Autowired
	private RoleService  	   roleService;
	@Autowired
	private PermissionService  permissionService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		Admin loginAdmin = (Admin) principal.fromRealm(getName()).iterator().next();
		
		SimpleAuthorizationInfo authInfo = null;
		if (loginAdmin != null) {
			authInfo = new SimpleAuthorizationInfo();
			for (Role role : loginAdmin.getRoleList()) {
				if (role.isAdministrator()) {
					return buildAdminAuthorizationInfo();
				} else {
					authInfo.addRole(role.getCode());
					for (Permission permission : role.getPermissionList()) {
						authInfo.addStringPermission(permission.getCode());
					}
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

		Admin loginAdmin = adminService.findByLoginName(loginName);
		
		if (loginAdmin == null) {
			throw new UnknownAccountException("Login admin [" + loginName + "] not exist" );
		} else if (!loginAdmin.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("Login admin [" + loginName + "] password error");
		} else if (loginAdmin.getLocked()) {
			throw new LockedAccountException("Login admin [" + loginName + "] is locked");
		} else {
			callbackOnLoginSuccess(loginAdmin.getId());
			return buildAdminAuthenticationInfo(loginAdmin);
		}
	}
	
	/**
	 * 登陆成功回调
	 */
	protected void callbackOnLoginSuccess(Integer adminId) {
		String loginIp = SecurityUtils.getSubject().getSession().getHost();
		
		Admin loginAdmin = new Admin(adminId);
		loginAdmin.setLastLoginIp(loginIp);
		loginAdmin.setLastLoginTime(DateUtil.getCurrentTime());
		
		adminService.editSelective(loginAdmin);
	}
	
	private AuthorizationInfo buildAdminAuthorizationInfo() {
		List<Role> roleList = roleService.queryAll();
		List<Permission> permissionList = permissionService.queryAll();
		
		SimpleAuthorizationInfo authInfo = null;
		if (!roleList.isEmpty() || !permissionList.isEmpty()) {
			authInfo = new SimpleAuthorizationInfo();
			for (Role role : roleList) {
				authInfo.addRole(role.getCode());
			}
			for (Permission permission : permissionList) {
				authInfo.addStringPermission(permission.getCode());
			}
		}
		
		return authInfo;
	}
	
	private AuthenticationInfo buildAdminAuthenticationInfo(Admin loginAdmin) {
		List<Role> roleList = roleService.queryAll(loginAdmin.getId());
		if (!roleList.isEmpty()) {
			for (Role role : roleList) {
				role.setPermissionList(permissionService.queryAll(role.getId()));
			}
		}
		loginAdmin.setRoleList(roleList);
		
		return new SimpleAuthenticationInfo(loginAdmin, loginAdmin.getPassword(), getName());
	}
	
}
