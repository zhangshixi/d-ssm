package com.dssm.service.manage.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dssm.domain.manage.Role;
import com.dssm.mapper.manage.RoleMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.manage.RoleService;

public class RoleServiceSupport extends AbstractService implements RoleService {

	@Autowired
    private RoleMapper roleMapper;

	@Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int removeRole(Long roleId) {
        return roleMapper.deleteById(roleId);
    }

    @Override
    public int editRole(Role role) {
        return roleMapper.updateSelective(role);
    }

    @Override
    public Role findRoleById(Long roleId) {
        return roleMapper.selectById(roleId);
    }

	@Override
	public List<Role> queryAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> queryAllRoles(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

}
