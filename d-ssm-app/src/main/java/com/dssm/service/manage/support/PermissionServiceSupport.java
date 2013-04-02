package com.dssm.service.manage.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.manage.Permission;
import com.dssm.domain.manage.Role;
import com.dssm.mapper.manage.PermissionMapper;
import com.dssm.mapper.manage.RoleMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.manage.PermissionService;

@Service
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

    @Override
    public List<Permission> queryPermissionsByRole(int roleId) {
        return permissionMapper.selectByRole(roleId);
    }

}
