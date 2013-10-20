package com.dssm.service.security;

import com.dssm.domain.security.Admin;
import com.dssm.service.BaseService;

public interface AdminService extends BaseService<Admin> {

    public Admin findByLoginName(String loginName);

	public void authorize(Integer id, Integer[] roleIds);
    
}