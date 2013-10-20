package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Admin;
import com.dssm.exception.BusinessException;
import com.dssm.exception.NotFoundException;
import com.dssm.mapper.security.AdminMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.AdminService;
import com.mtoolkit.cache.callback.KeyGenerator;
import com.mtoolkit.cache.callback.ValueLoader;
import com.mtoolkit.page.Page;
import com.mtoolkit.util.EmptyUtil;

@Service
public class AdminServiceSupport extends AbstractService<Admin> implements AdminService {
    
	@Autowired
    private AdminMapper adminMapper;
	private static final Integer ADMINISTRATOR_ID = Integer.valueOf(1);
    
    @Override
    public void init() {
        super.init();
        
        List<Admin> allAdminList = adminMapper.selectAll();
        for (Admin admin : allAdminList) {
            getCache().asyncPut(new AdminIdCacheKeyGenerator(admin.getId()), admin, EXPIRED_TIME);
        }
    }

    @Override
    public Integer add(Admin admin) {
        if (findByLoginName(admin.getLoginName()) != null) {
            throw new BusinessException("用户名[{0}]已存在！", admin.getLoginName());
        }
        
        return adminMapper.insert(admin);
    }

    @Override
    public int removeById(Integer adminId) {
    	if (ADMINISTRATOR_ID.equals(adminId)) {
    		throw new BusinessException("超级管理员不能被删除！");
    	}
    	
    	Admin targetAdmin = findById(adminId);
    	if (targetAdmin == null) {
    		throw new NotFoundException("指定删除的管理员不存在！");
    	}
    	
    	getCache().asyncRemove(new AdminIdCacheKeyGenerator(adminId));
    	getCache().asyncRemove(new AdminNameCacheKeyGenerator(targetAdmin.getLoginName()));
    	
        return adminMapper.deleteById(adminId);
    }

    @Override
    public int editSelective(Admin admin) {
    	if (admin.getLoginName() != null) {
    		Admin nameAdmin = findByLoginName(admin.getLoginName());
            if (nameAdmin != null && nameAdmin.getId() != admin.getId()) {
                throw new BusinessException("用户名[{0}]已存在！", admin.getLoginName());
            } else if (nameAdmin == null) {
                getCache().asyncRemove(new AdminNameCacheKeyGenerator(admin.getLoginName()));
            }
    	}
        
    	getCache().asyncRemove(new AdminIdCacheKeyGenerator(admin.getId()));
    	
        return adminMapper.updateSelective(admin);
    }

	@Override
    public Admin findById(Integer adminId) {
        return getCache().get(new AdminIdCacheKeyGenerator(adminId), new AdminValueLoader(adminId, adminMapper), EXPIRED_TIME);
    }     

    @Override
    public Admin findByLoginName(String loginName) {
        Integer adminId = getCache().get(new AdminNameCacheKeyGenerator(loginName), new AdminIdValueLoader(loginName, adminMapper), EXPIRED_TIME);
        return findById(adminId);
    }
    
    @Override
    public List<Admin> queryByPage(Page<Admin> page, Admin search) {
    	return adminMapper.selectByPage(page, search);
    }
    
    @Override
    public List<Admin> queryAll() {
    	return adminMapper.selectAll();
    }

	@Override
	public void authorize(Integer adminId, Integer[] roleIds) {
		adminMapper.deleteRelateRoles(adminId);
		if (EmptyUtil.isNotNullEmpty(roleIds)) {
			adminMapper.insertRelateRoles(adminId, roleIds);
		}
	}
    
    /* ---- private methods ---- */
    
    /* ---- inner classes ---- */
    private static final long EXPIRED_TIME = 1 * 24 * 60 * 60 * 1000L;
    
    public static class AdminIdCacheKeyGenerator implements KeyGenerator {
        
        private Integer adminId;
        public AdminIdCacheKeyGenerator(Integer adminId) {
            this.adminId = adminId;
        }
        
		@Override
		public String generateKey() {
			return Admin.class.getName() + ".id." + adminId;
		}
    }
    
    public static class AdminValueLoader implements ValueLoader<Admin> {
    	
        private Integer adminId;
        private AdminMapper adminMapper;
        public AdminValueLoader(Integer adminId, AdminMapper adminMapper) {
            this.adminId = adminId;
            this.adminMapper = adminMapper;
        }
        
        @Override
        public Admin loadValue() {
            return adminMapper.selectById(adminId);
        }
    }
    
    public static class AdminNameCacheKeyGenerator implements KeyGenerator {
    	
    	private String loginName;
    	public AdminNameCacheKeyGenerator(String loginName) {
    		this.loginName = loginName;
    	}
    	
    	@Override
    	public String generateKey() {
    		return Admin.class.getName() + ".name." + loginName;
    	}
    }
    
    public static class AdminIdValueLoader implements ValueLoader<Integer> {

    	private String loginName;
        private AdminMapper adminMapper;
		public AdminIdValueLoader(String loginName, AdminMapper adminMapper) {
			this.loginName = loginName;
			this.adminMapper = adminMapper;
		}

		@Override
		public Integer loadValue() {
			Admin admin = adminMapper.selectByLoginName(loginName);
			return admin == null ? null : admin.getId();
		}
    }

}
