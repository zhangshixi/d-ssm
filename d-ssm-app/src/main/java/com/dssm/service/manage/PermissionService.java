package com.dssm.service.manage;

import java.util.List;

import com.dssm.domain.manage.Permission;
import com.dssm.domain.manage.Role;
import com.dssm.service.BaseService;

public interface PermissionService extends BaseService {
    
    public int addRole(Role role);
    
    public int removeRole(int roleId);
    
    public int editRole(Role role);
    
    public Role findRoleById(int roleId);
    
    
    public int addPermission(Permission permission);
    
    public int removePermission(int permissionId);
    
    public int editPermission(Permission permission);
    
    public Permission findPermissionById(int permissionId);
    
    public List<Permission> queryPermissionsByRole(int roleId);
    
}
