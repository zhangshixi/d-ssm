package com.dssm.service.security;

import java.util.List;

import com.dssm.domain.security.Menu;
import com.dssm.service.BaseService;

public interface MenuService extends BaseService<Menu> {

	public Menu findByCode(String code);

	public List<Menu> queryAll(Boolean display);
	
	public List<Menu> queryAllTree(Boolean display);
	
}
