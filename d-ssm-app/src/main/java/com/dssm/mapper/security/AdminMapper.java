package com.dssm.mapper.security;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dssm.domain.security.Admin;
import com.dssm.mapper.BaseMapper;

public interface AdminMapper extends BaseMapper<Admin> {
	
    public Admin selectByLoginName(String name);
    
    public List<Admin> selectAll();

	public int deleteRelateRoles(Integer adminId);

	public int insertRelateRoles(@Param("adminId") Integer adminId, @Param("roleIds") Integer[] roleIds);
    
}