package com.dssm.service.security.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			asyncPut(CacheTactics.generateRoleCodeIdMappingCacheKey(role.getCode()), role.getId(), CacheTactics.EXPIRED_TIME);
			asyncPut(CacheTactics.generateRoleCacheKey(role.getId()), role, CacheTactics.EXPIRED_TIME);
		}
		asyncPut(CacheTactics.generateRoleIdListCacheKey(), roleIdList);
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
    	
    	asyncRemove(CacheTactics.generateRoleCacheKey(roleId));
    	
        return roleMapper.deleteById(roleId);
    }

    @Override
    public int editSelective(Role role) {
    	if (EmptyUtil.isNotNullEmpty(role.getCode())) {
    		Role targetRole = findByCode(role.getCode());
    		if (targetRole != null && !targetRole.getId().equals(role.getId())) {
    			throw new BusinessException("角色编码[{0}]已存在！", role.getCode());
    		} else if (targetRole == null) {
    			asyncRemove(CacheTactics.generateRoleCodeIdMappingCacheKey(role.getCode()));
    		}
    	}

    	asyncRemove(CacheTactics.generateRoleCacheKey(role.getId()));
    	
        return roleMapper.updateSelective(role);
    }

    @Override
    public Role findById(Integer roleId) {
    	Role targetRole = get(CacheTactics.generateRoleCacheKey(roleId));
    	
    	if (targetRole == null) {
    		targetRole = roleMapper.selectById(roleId);
    		asyncPut(CacheTactics.generateRoleCacheKey(roleId), targetRole, CacheTactics.EXPIRED_TIME);
    	}
    	
        return targetRole;
    }

    @Override
    public Role findByCode(String code) {
    	Integer roleId = get(CacheTactics.generateRoleCodeIdMappingCacheKey(code));
    	
    	Role targetRole = null;
    	if (roleId == null) {
    		targetRole = roleMapper.selectByCode(code);
    		if (targetRole != null) {
    			asyncPut(CacheTactics.generateRoleCodeIdMappingCacheKey(code), targetRole.getId(), CacheTactics.EXPIRED_TIME);
    			asyncPut(CacheTactics.generateRoleCacheKey(targetRole.getId()), targetRole, CacheTactics.EXPIRED_TIME);
    		}
    	}
    	
        return targetRole;
    }
    
    @Override
    public List<Role> queryByPage(Page<Role> page, Role search) {
    	List<Integer> roleIdList = get(CacheTactics.generateRoleIdListCacheKey());
    	
    	if (roleIdList == null) {
    		// TODO:
    	}
    	
    	page.setTotalData(roleIdList.size());
    	List<Integer> pageIdList = roleIdList.subList(page.getFromIndex(), page.getToIndex());
    	
    	Map<String, Integer> queryKeyMap = new HashMap<String, Integer>(pageIdList.size(), 1F);
    	for (Integer roleId : pageIdList) {
    		queryKeyMap.put(CacheTactics.generateRoleCacheKey(roleId), roleId);
    	}
    	
    	// query from cache
    	Map<Integer, String> unCachedKeys = new HashMap<Integer, String>();
    	String[] queryKeys = queryKeyMap.keySet().toArray(new String[0]);
	    Map<String, Role> cachedResultMap = get(queryKeys);
	    for (String key : queryKeys) {
	        if (!cachedResultMap.containsKey(key)) {
	            unCachedKeys.put(queryKeyMap.get(key), key);
	        }
	    }
    	
    	if (!unCachedKeys.isEmpty()) {
    		Map<Integer, Role> dbRoleMap = roleMapper.batchSelectByIds(new ArrayList<Integer>(unCachedKeys.keySet()));
    		
    	}
    	
    	
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
	
	public static class CacheTactics {
		
		public static final long EXPIRED_TIME = 1 * 24 * 60 * 60 * 1000L;
		
		public static String generateRoleCacheKey(Integer roleId) {
			return Role.class.getName() + ".id." + roleId;
		}
		
		public static String generateRoleCodeIdMappingCacheKey(String roleCode) {
			return Role.class.getName() + ".name." + roleCode;
		}
		
		public static String generateRoleIdListCacheKey() {
			return Role.class.getName() + ".id.list";
		}
		
	}
	
}
