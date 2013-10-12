package com.dssm.mapper.security;

import java.util.List;

import com.dssm.domain.security.Admin;
import com.dssm.mapper.BaseMapper;

public interface AdminMapper extends BaseMapper<Admin> {
	
    public Admin selectByLoginName(String name);
    
    public List<Admin> selectAll();
    
}