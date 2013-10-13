package com.dssm.service.security;

import java.util.List;

import com.dssm.domain.security.Role;
import com.dssm.service.BaseService;

public interface RoleService extends BaseService<Role> {

	public Role findByCode(String code);

	public List<Role> queryAll(Integer adminId);
	
}
