package com.mjee.mapper.manage;

import com.mjee.domain.manage.Admin;
import com.mjee.mapper.BaseMapper;

public interface AdminMapper extends BaseMapper<Admin> {
	
    public Admin selectByName(String name);
    
}