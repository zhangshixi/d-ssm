package com.dssm.service.manage;

import java.util.List;

import com.dssm.domain.manage.Role;
import com.dssm.service.BaseService;

public interface RoleService extends BaseService {

	public int addRole(Role role);

	public int removeRole(Long roleId);

	public int editRole(Role role);

	public Role findRoleById(Long roleId);

	public List<Role> queryAllRoles();
	
	public List<Role> queryAllRoles(Long adminId);
	
}
