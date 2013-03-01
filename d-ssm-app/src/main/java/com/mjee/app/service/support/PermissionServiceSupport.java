package com.mjee.app.service.support;

import org.springframework.beans.factory.annotation.Autowired;

import com.mjee.app.domain.Permission;
import com.mjee.app.domain.Role;
import com.mjee.app.mapper.PermissionMapper;
import com.mjee.app.mapper.RoleMapper;
import com.mjee.app.service.AbstractService;
import com.mjee.app.service.PermissionService;

public class PermissionServiceSupport extends AbstractService implements PermissionService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int removeRole(int roleId) {
        return roleMapper.delete(roleId);
    }

    @Override
    public int editRole(Role role) {
        return roleMapper.updateSelective(role);
    }

    @Override
    public Role findRoleById(int roleId) {
        return roleMapper.selectById(roleId);
    }

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int removePermission(int permissionId) {
        return permissionMapper.delete(permissionId);
    }

    @Override
    public int editPermission(Permission permission) {
        return permissionMapper.updateSelective(permission);
    }

    @Override
    public Permission findPermissionById(int permissionId) {
        return permissionMapper.selectById(permissionId);
    }

}
