package com.mjee.app.service;

import com.mjee.app.domain.Permission;
import com.mjee.app.domain.Role;

public interface PermissionService extends BaseService {
    
    public int addRole(Role role);
    
    public int removeRole(int roleId);
    
    public int editRole(Role role);
    
    public Role findRoleById(int roleId);
    
    
    public int addPermission(Permission permission);
    
    public int removePermission(int permissionId);
    
    public int editPermission(Permission permission);
    
    public Permission findPermissionById(int permissionId);
    
}
