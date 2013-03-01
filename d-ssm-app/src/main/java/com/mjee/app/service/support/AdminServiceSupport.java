package com.mjee.app.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjee.app.domain.Admin;
import com.mjee.app.mapper.AdminMapper;
import com.mjee.app.service.AbstractService;
import com.mjee.app.service.AdminService;

@Service
public class AdminServiceSupport extends AbstractService implements AdminService {
    
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int removeAdmin(int adminId) {
        return adminMapper.delete(adminId);
    }

    @Override
    public int editAdmin(Admin admin) {
        return adminMapper.update(admin);
    }

    @Override
    public Admin findAdminById(int adminId) {
        return adminMapper.selectById(adminId);
    }

    @Override
    public Admin findAdminByName(String name) {
        return adminMapper.selectByName(name);
    }
    
}
