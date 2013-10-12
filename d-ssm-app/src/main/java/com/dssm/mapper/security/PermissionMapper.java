package com.dssm.mapper.security;

import java.util.List;

import com.dssm.domain.security.Permission;
import com.dssm.mapper.BaseMapper;

public interface PermissionMapper extends BaseMapper<Permission> {
    
    public List<Permission> selectByRole(Long roleId);
    
}
