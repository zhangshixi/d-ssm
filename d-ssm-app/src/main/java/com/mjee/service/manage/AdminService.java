package com.mjee.service.manage;

import com.mjee.domain.manage.Admin;
import com.mjee.service.BaseService;

public interface AdminService extends BaseService {

    public int newAdmin(Admin admin);
    
    public int removeAdmin(int adminId);
    
    public int editAdmin(Admin admin);
    
    public Admin findAdminById(int adminId);
    
    public Admin findAdminByName(String name);
    
}