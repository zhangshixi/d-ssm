package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Role;
import com.dssm.mapper.security.RoleMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.RoleService;
import com.mtoolkit.page.Page;

@Service
public class RoleServiceSupport extends AbstractService<Role> implements RoleService {

	@Autowired
    private RoleMapper roleMapper;

	@Override
    public Integer add(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int removeById(Integer roleId) {
        return roleMapper.deleteById(roleId);
    }

    @Override
    public int editSelective(Role role) {
        return roleMapper.updateSelective(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleMapper.selectById(roleId);
    }

    @Override
    public Role findByCode(String code) {
        return roleMapper.selectByCode(code);
    }
    
    @Override
    public List<Role> queryByPage(Page<Role> page, Role search) {
    	return roleMapper.selectByPage(page, search);
    }
    
	@Override
	public List<Role> queryAll() {
		return queryAll(null);
	}

	@Override
	public List<Role> queryAll(Integer adminId) {
		return roleMapper.selectAll(adminId);
	}
	
}
