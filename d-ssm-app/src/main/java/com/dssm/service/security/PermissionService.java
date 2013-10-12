package com.dssm.service.security;

import java.util.List;

import com.dssm.domain.security.Permission;
import com.dssm.service.BaseService;

public interface PermissionService extends BaseService {
    
    public int addPermission(Permission permission);
    
    public int removePermission(Long permissionId);
    
    public int editPermission(Permission permission);
    
    public Permission findPermissionById(Long permissionId);
    
    public List<Permission> queryAllPermissions();
    
    public List<Permission> queryAllPermissions(Long roleId);
    
}
