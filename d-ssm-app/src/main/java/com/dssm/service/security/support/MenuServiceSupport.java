package com.dssm.service.security.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Menu> queryAll(Boolean display) {
		return menuMapper.selectAll(display);
	}
	
	@Override
	public List<Menu> queryAllTree(Boolean display) {
		List<Menu> menuList = queryAll(display);
		if (menuList == null || menuList.isEmpty()) {
			return Collections.emptyList();
		}
		
		return buildTree(menuList);
	}
	
	private List<Menu> buildTree(List<Menu> menuList) {
	    Map<Integer, Menu> topMap = new HashMap<Integer, Menu>();
	    
	    for (Menu menu : menuList) {
	        if (menu.isTopLevel()) {
	            topMap.put(menu.getId(), menu);
	        } else if (menu.getParent().isTopLevel()) {
	            Menu parentMenu = topMap.get(menu.getParent().getId());
	            List<Menu> childMenuList = parentMenu.getChildList();
	            if (childMenuList == null) {
	                childMenuList = new ArrayList<Menu>();
	            }
	            childMenuList.add(menu);
	            parentMenu.setChildList(childMenuList);
	        }
	    }
	    
	    List<Menu> resultList = new ArrayList<Menu>(topMap.size());
	    for (Menu menu : menuList) {
	        if (topMap.get(menu.getId()) != null) {
	            resultList.add(topMap.get(menu.getId()));
	        }
	    }
	    
	    return resultList;
	}
	
}
