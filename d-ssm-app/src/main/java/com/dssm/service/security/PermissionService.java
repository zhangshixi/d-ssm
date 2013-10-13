package com.dssm.service.security;

import java.util.List;

import com.dssm.domain.security.Permission;
import com.dssm.service.BaseService;

public interface PermissionService extends BaseService<Permission> {
	
	public Permission findByCode(String code);
    
    public List<Permission> queryAll();
    
    public List<Permission> queryAll(Integer roleId);


}
