package com.dssm.service.manage;

import com.dssm.domain.manage.Admin;
import com.dssm.service.BaseService;

public interface AdminService extends BaseService {

    public int addAdmin(Admin admin);
    
    public int removeAdmin(int adminId);
    
    public int editAdmin(Admin admin);
    
    public Admin findAdminById(int adminId);
    
    public Admin findAdminByName(String name);
    
}