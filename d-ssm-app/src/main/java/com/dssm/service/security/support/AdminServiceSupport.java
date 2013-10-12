package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Admin;
import com.dssm.exception.BusinessException;
import com.dssm.mapper.security.AdminMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.AdminService;
import com.mtoolkit.page.Page;
//import com.mcache.callback.ExpiredValueLoader;
//import com.mcache.callback.KeyGenerator;

@Service
public class AdminServiceSupport extends AbstractService implements AdminService {
    
    @Autowired
    private AdminMapper adminMapper;
    
    @Override
    public void init() {
        super.init();
        
        List<Admin> allAdminList = adminMapper.selectAll();
        for (Admin admin : allAdminList) {
//            asyncPut(new AdminIdCacheKeyGenerator(admin.getId()), admin, EXPIRED_TIME);
        }
    }

    @Override
    public int addAdmin(Admin admin) {
        if (adminMapper.selectByLoginName(admin.getLoginName()) != null) {
            throw new BusinessException("用户名[{0}]已存在！", admin.getLoginName());
        }
        
        return adminMapper.insert(admin);
    }

    @Override
    public int removeAdmin(Long adminId) {
        int row = adminMapper.deleteById(adminId);
//        asyncRemove(new AdminIdCacheKeyGenerator(adminId));
        return row;
    }

    @Override
    public int editAdmin(Admin admin) {
    	if (admin.getLoginName() != null) {
    		doValidateAdmin(admin);
    	}
         
        int row = adminMapper.updateSelective(admin);
//        asyncRemove(new AdminIdCacheKeyGenerator(admin.getId()));
        return row;
    }

	@Override
    public Admin findAdminById(Long adminId) {
//        return get(new AdminIdCacheKeyGenerator(adminId), new AdminValueLoader(adminId, EXPIRED_TIME, adminMapper));
    	return adminMapper.selectById(adminId);
    }     

    @Override
    public Admin findAdminByLoginName(String loginName) {
//        Integer adminId = get(new AdminNameCacheKeyGenerator(adminName));
//        if (adminId != null) {
//            return findAdminById(adminId.intValue());
//        } else {
            Admin admin = adminMapper.selectByLoginName(loginName);
//            if (admin != null) {
//                asyncPut(new AdminNameCacheKeyGenerator(adminName), Integer.valueOf(admin.getId()), EXPIRED_TIME);
//            }
            return admin;
//        }
    }
    
    @Override
    public List<Admin> queryAdminsByPage(Page<Admin> page, Admin search) {
    	return adminMapper.selectByPage(page, search);
    }
    
    @Override
    public List<Admin> queryAllAdmins() {
    	return adminMapper.selectAll();
    }
    
    
    /* ---- private methods ---- */
    private void doValidateAdmin(Admin admin) {
    	Admin nameAdmin = adminMapper.selectByLoginName(admin.getLoginName());
        if (nameAdmin != null && nameAdmin.getId() != admin.getId()) {
            throw new BusinessException("用户名[{0}]已存在！", admin.getLoginName());
        }
	}
    
    /* ---- inner classes ---- */
    private static final long EXPIRED_TIME = 7 * 24 * 60 * 60 * 1000;
    
//    private static class AdminIdCacheKeyGenerator implements KeyGenerator {
//        
//        private int adminId;
//        public AdminIdCacheKeyGenerator(int adminId) {
//            this.adminId = adminId;
//        }
//        
//        @Override
//        public String generateKey() {
//            return Admin.class.getName() + ".id." + adminId;
//        }
//    }
//    
//    private static class AdminNameCacheKeyGenerator implements KeyGenerator {
//        
//        private String adminName;
//        public AdminNameCacheKeyGenerator(String adminName) {
//            this.adminName = adminName;
//        }
//        
//        @Override
//        public String generateKey() {
//            return Admin.class.getName() + ".name." + adminName;
//        }
//    }
//    
//    private static class AdminValueLoader implements ExpiredValueLoader<Admin> {
//        private int adminId;
//        private long expiredTime;
//        private AdminMapper adminMapper;
//        
//        public AdminValueLoader(int adminId, long expiredTime, AdminMapper adminMapper) {
//            this.adminId = adminId;
//            this.expiredTime = expiredTime;
//            this.adminMapper = adminMapper;
//        }
//        
//        @Override
//        public Admin loadValue() {
//            return adminMapper.selectById(adminId);
//        }
//
//        @Override
//        public long getExpiredTime() {
//            return expiredTime;
//        }
//    }
    
}
