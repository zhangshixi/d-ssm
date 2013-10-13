package com.dssm.mapper.security;

import java.util.List;

import com.dssm.domain.security.Permission;
import com.dssm.mapper.BaseMapper;

public interface PermissionMapper extends BaseMapper<Permission> {
    
	public Permission selectByCode(String code);
	
    public List<Permission> selectAll(Integer roleId);
    
}
