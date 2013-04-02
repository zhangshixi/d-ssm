package com.dssm.service.manage.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.manage.Admin;
import com.dssm.exception.BusinessException;
import com.dssm.mapper.manage.AdminMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.manage.AdminService;
import com.mcache.callback.ExpiredValueLoader;
import com.mcache.callback.KeyGenerator;

@Service
public class AdminServiceSupport extends AbstractService implements AdminService {
    
    @Autowired
    private AdminMapper adminMapper;
    
    @Override
    public void init() {
        super.init();
        
        List<Admin> allAdminList = adminMapper.selectAll();
        for (Admin admin : allAdminList) {
            asyncPut(new AdminIdCacheKeyGenerator(admin.getId()), admin, EXPIRED_TIME);
        }
    }

    @Override
    public int addAdmin(Admin admin) {
        if (adminMapper.selectByName(admin.getName()) != null) {
            throw new BusinessException("用户名[{0}]已存在！", admin.getName());
        }
        
        return adminMapper.insert(admin);
    }

    @Override
    public int removeAdmin(int adminId) {
        int row = adminMapper.deleteById(adminId);
        asyncRemove(new AdminIdCacheKeyGenerator(adminId));
        return row;
    }

    @Override
    public int editAdmin(Admin admin) {
        Admin nameAdmin = adminMapper.selectByName(admin.getName());
        if (nameAdmin != null && nameAdmin.getId() != admin.getId()) {
            throw new BusinessException("用户名[{0}]已存在！", admin.getName());
        }
        
        int row = adminMapper.update(admin);
        asyncRemove(new AdminIdCacheKeyGenerator(admin.getId()));
        return row;
    }

    @Override
    public Admin findAdminById(int adminId) {
        return get(new AdminIdCacheKeyGenerator(adminId), new AdminValueLoader(adminId, EXPIRED_TIME, adminMapper));
    }

    @Override
    public Admin findAdminByName(String adminName) {
        Integer adminId = get(new AdminNameCacheKeyGenerator(adminName));
        if (adminId != null) {
            return findAdminById(adminId.intValue());
        } else {
            Admin admin = adminMapper.selectByName(adminName);
            if (admin != null) {
                asyncPut(new AdminNameCacheKeyGenerator(adminName), Integer.valueOf(admin.getId()), EXPIRED_TIME);
            }
            return admin;
        }
    }
    
    /* ---- inner classes ---- */
    private static final long EXPIRED_TIME = 7 * 24 * 60 * 60 * 1000;
    
    private static class AdminIdCacheKeyGenerator implements KeyGenerator {
        
        private int adminId;
        public AdminIdCacheKeyGenerator(int adminId) {
            this.adminId = adminId;
        }
        
        @Override
        public String generateKey() {
            return Admin.class.getName() + ".id." + adminId;
        }
    }
    
    private static class AdminNameCacheKeyGenerator implements KeyGenerator {
        
        private String adminName;
        public AdminNameCacheKeyGenerator(String adminName) {
            this.adminName = adminName;
        }
        
        @Override
        public String generateKey() {
            return Admin.class.getName() + ".name." + adminName;
        }
    }
    
    private static class AdminValueLoader implements ExpiredValueLoader<Admin> {
        private int adminId;
        private long expiredTime;
        private AdminMapper adminMapper;
        
        public AdminValueLoader(int adminId, long expiredTime, AdminMapper adminMapper) {
            this.adminId = adminId;
            this.expiredTime = expiredTime;
            this.adminMapper = adminMapper;
        }
        
        @Override
        public Admin loadValue() {
            return adminMapper.selectById(adminId);
        }

        @Override
        public long getExpiredTime() {
            return expiredTime;
        }
    }
    
}
