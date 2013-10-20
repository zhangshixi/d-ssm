package com.dssm.service.security.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Role;
import com.dssm.exception.BusinessException;
import com.dssm.exception.NotFoundException;
import com.dssm.mapper.security.RoleMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.RoleService;
import com.mtoolkit.page.Page;
import com.mtoolkit.util.EmptyUtil;

@Service
public class RoleServiceSupport extends AbstractService<Role> implements RoleService {

	@Autowired
    private RoleMapper roleMapper;

	@Override
	public void init() {
		super.init();
		
		List<Role> roleList = roleMapper.selectAll(null);
		List<Integer> roleIdList = new ArrayList<Integer>(roleList.size());
		for (Role role : roleList) {
			roleIdList.add(role.getId());
			
			getCache().asyncPut(RoleCache.generateRoleCodeIdMappingCacheKey(role.getCode()), role.getId(), RoleCache.EXPIRED_TIME);
			getCache().asyncPut(RoleCache.generateRoleCacheKey(role.getId()), role, RoleCache.EXPIRED_TIME);
		}
	}
	
	@Override
    public Integer add(Role role) {
		if (findByCode(role.getCode()) != null) {
            throw new BusinessException("角色编码[{0}]已存在！",role.getCode());
        }
		
        return roleMapper.insert(role);
    }

    @Override
    public int removeById(Integer roleId) {
    	Role targetRole = findById(roleId);
    	if (targetRole == null) {
    		throw new NotFoundException("指定删除的角色不存在！");
    	}
    	
    	getCache().asyncRemove(RoleCache.generateRoleCacheKey(roleId));
    	
        return roleMapper.deleteById(roleId);
    }

    @Override
    public int editSelective(Role role) {
    	if (EmptyUtil.isNotNullEmpty(role.getCode())) {
    		Role targetRole = findByCode(role.getCode());
    		if (targetRole != null && !targetRole.getId().equals(role.getId())) {
    			throw new BusinessException("角色编码[{0}]已存在！", role.getCode());
    		} else if (targetRole == null) {
    		    getCache().asyncRemove(RoleCache.generateRoleCodeIdMappingCacheKey(role.getCode()));
    		}
    	}

    	getCache().asyncRemove(RoleCache.generateRoleCacheKey(role.getId()));
    	
        return roleMapper.updateSelective(role);
    }

    @Override
    public Role findById(Integer roleId) {
    	Role targetRole = getCache().get(RoleCache.generateRoleCacheKey(roleId));
    	
    	if (targetRole == null) {
    		targetRole = roleMapper.selectById(roleId);
    		getCache().asyncPut(RoleCache.generateRoleCacheKey(roleId), targetRole, RoleCache.EXPIRED_TIME);
    	}
    	
        return targetRole;
    }

    @Override
    public Role findByCode(String code) {
    	Integer roleId = getCache().get(RoleCache.generateRoleCodeIdMappingCacheKey(code));
    	
    	Role targetRole = null;
    	if (roleId == null) {
    		targetRole = roleMapper.selectByCode(code);
    		if (targetRole != null) {
    		    getCache().asyncPut(RoleCache.generateRoleCodeIdMappingCacheKey(code), targetRole.getId(), RoleCache.EXPIRED_TIME);
    			getCache().asyncPut(RoleCache.generateRoleCacheKey(targetRole.getId()), targetRole, RoleCache.EXPIRED_TIME);
    		}
    	}
    	
        return targetRole;
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
	
	@Override
	public void authorize(Integer roleId, Integer[] permissionIds) {
		roleMapper.deleteRelatePermissions(roleId);
		if (EmptyUtil.isNotNullEmpty(permissionIds)) {
			roleMapper.insertRelatePermissions(roleId, permissionIds);
		}
	}
	
	public static class RoleCache {
		
		public static final long EXPIRED_TIME = 1 * 24 * 60 * 60 * 1000L;
		
		public static String generateRoleCacheKey(Integer roleId) {
			return Role.class.getName() + ".id." + roleId;
		}
		
		public static String generateRoleCodeIdMappingCacheKey(String roleCode) {
			return Role.class.getName() + ".name." + roleCode;
		}
		
	}
	
}
