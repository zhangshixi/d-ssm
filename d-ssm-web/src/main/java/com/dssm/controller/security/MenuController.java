package com.dssm.controller.security;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.domain.security.Menu;
import com.dssm.service.security.MenuService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
    
	@Autowired
    private MenuService menuService;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Menu menu) {
		menu.setUpdateAid(getLoginAdminId());
	    menuService.add(menu);
	    
		return redirectTo("/menu");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Menu targetMenu = menuService.findById(id);
	    modelMap.put("target", targetMenu);
	    
		return view("show");
	}

	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Menu menu = menuService.findById(id);
	    if (menu == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", menu);
	        return view("edit");
	    }
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Menu menu) {
	    menu.setId(id);
	    menu.setUpdateAid(getLoginAdminId());
	    menuService.editSelective(menu);
	    
		return redirectTo("/menu/{0}", id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		menuService.removeById(id);
		
	    return redirectTo("/menu");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return view("index");
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Menu> page, Menu menu, ModelMap modelMap) {
//		List<Menu> menuList = menuService.queryByPage(page, menu);
//		modelMap.put("page", page);
		
		List<Menu> menuList = menuService.queryAll(null);
		modelMap.put("resultList", menuList);
		
		return view("list");
	}
	
}