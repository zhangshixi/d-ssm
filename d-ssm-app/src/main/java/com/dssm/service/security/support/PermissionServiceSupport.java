package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Permission;
import com.dssm.mapper.security.PermissionMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.PermissionService;

@Service
public class PermissionServiceSupport extends AbstractService implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int removePermission(Long permissionId) {
        return permissionMapper.deleteById(permissionId);
    }

    @Override
    public int editPermission(Permission permission) {
        return permissionMapper.updateSelective(permission);
    }

    @Override
    public Permission findPermissionById(Long permissionId) {
        return permissionMapper.selectById(permissionId);
    }

    @Override
    public List<Permission> queryAllPermissions() {
        return queryAllPermissions(null);
    }
    
    @Override
    public List<Permission> queryAllPermissions(Long roleId) {
    	return permissionMapper.selectByRole(roleId);
    }

}
