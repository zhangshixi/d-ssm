package com.dssm.mapper.security;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dssm.domain.security.Role;
import com.dssm.mapper.BaseMapper;

public interface RoleMapper extends BaseMapper<Role> {

	public Role selectByCode(String code);

	public List<Role> selectAll(Integer adminId);

	public int deleteRelatePermissions(Integer roleId);

	public int insertRelatePermissions(@Param("roleId") Integer roleId, @Param("permissionIds") Integer[] permissionIds);
	
}