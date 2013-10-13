package com.dssm.mapper.security;

import java.util.List;

import com.dssm.domain.security.Menu;
import com.dssm.mapper.BaseMapper;

public interface MenuMapper extends BaseMapper<Menu> {

	public Menu selectByCode(String code);

	public List<Menu> selectAll(Integer adminId);
	
}