package com.mjee.service.manage.support;

import org.springframework.beans.factory.annotation.Autowired;

import com.mjee.domain.manage.Permission;
import com.mjee.domain.manage.Role;
import com.mjee.mapper.manage.PermissionMapper;
import com.mjee.mapper.manage.RoleMapper;
import com.mjee.service.AbstractService;
import com.mjee.service.manage.PermissionService;

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
        return roleMapper.deleteById(roleId);
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
        return permissionMapper.deleteById(permissionId);
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
