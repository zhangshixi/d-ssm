package com.dssm.service.manage;

import java.util.List;

import com.dssm.domain.manage.Admin;
import com.dssm.service.BaseService;
import com.mtoolkit.page.Page;

public interface AdminService extends BaseService {

    public int addAdmin(Admin admin);
    
    public int removeAdmin(Long adminId);
    
    public int editAdmin(Admin admin);
    
    public Admin findAdminById(Long adminId);
    
    public Admin findAdminByLoginName(String loginName);
    
    public List<Admin> queryAdminsByPage(Page<Admin> page, Admin search);
    
    public List<Admin> queryAllAdmins();
    
}