package com.mjee.app.mapper;

import com.mjee.app.domain.Admin;

public interface AdminMapper extends BaseMapper<Admin> {
	
    public Admin selectByName(String name);
    
}