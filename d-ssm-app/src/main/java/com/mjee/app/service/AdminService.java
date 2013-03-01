package com.mjee.app.service;

import com.mjee.app.domain.Admin;

public interface AdminService extends BaseService {

    public int addAdmin(Admin admin);
    
    public int removeAdmin(int adminId);
    
    public int editAdmin(Admin admin);
    
    public Admin findAdminById(int adminId);
    
    public Admin findAdminByName(String name);
    
}