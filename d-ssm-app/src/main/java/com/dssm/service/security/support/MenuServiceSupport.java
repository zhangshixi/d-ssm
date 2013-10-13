package com.dssm.service.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.security.Menu;
import com.dssm.mapper.security.MenuMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.security.MenuService;
import com.mtoolkit.page.Page;

@Service
public class MenuServiceSupport extends AbstractService<Menu> implements MenuService {

	@Autowired
    private MenuMapper menuMapper;

	@Override
    public Integer add(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int removeById(Integer menuId) {
        return menuMapper.deleteById(menuId);
    }

    @Override
    public int editSelective(Menu menu) {
        return menuMapper.updateSelective(menu);
    }

    @Override
    public Menu findById(Integer menuId) {
        return menuMapper.selectById(menuId);
    }

    @Override
    public Menu findByCode(String code) {
        return menuMapper.selectByCode(code);
    }
    
    @Override
    public List<Menu> queryByPage(Page<Menu> page, Menu search) {
    	return menuMapper.selectByPage(page, search);
    }
    
	@Override
	public List<Menu> queryAll() {
		return queryAll(null);
	}

	@Override
	public List<Menu> queryAll(Integer menuId) {
		return menuMapper.selectAll(menuId);
	}
	
}
