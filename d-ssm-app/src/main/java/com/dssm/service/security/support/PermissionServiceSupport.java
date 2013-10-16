package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Permission;
import com.dssm.mapper.security.PermissionMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.PermissionService;
import com.mtoolkit.page.Page;

@Service
public class PermissionServiceSupport extends AbstractService<Permission> implements PermissionService {

	@Autowired
    private PermissionMapper permissionMapper;

	@Override
    public Integer add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int removeById(Integer permissionId) {
        return permissionMapper.deleteById(permissionId);
    }

    @Override
    public int editSelective(Permission permission) {
        return permissionMapper.updateSelective(permission);
    }

    @Override
    public Permission findById(Integer permissionId) {
        return permissionMapper.selectById(permissionId);
    }

    @Override
    public Permission findByCode(String code) {
        return permissionMapper.selectByCode(code);
    }
    
    @Override
    public List<Permission> queryByPage(Page<Permission> page, Permission search) {
    	return permissionMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Permission> queryAll() {
		return queryAll(null);
	}

	@Override
	public List<Permission> queryAll(Integer roleId) {
		return permissionMapper.selectAll(roleId);
	}

}
