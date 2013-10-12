package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dssm.domain.security.Role;
import com.dssm.mapper.security.RoleMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.RoleService;

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
