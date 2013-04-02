package com.dssm.mapper.manage;

import java.util.List;

import com.dssm.domain.manage.Admin;
import com.dssm.mapper.BaseMapper;

public interface AdminMapper extends BaseMapper<Admin> {
	
    public Admin selectByName(String name);
    
    public List<Admin> selectAll();
    
}