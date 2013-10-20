package com.dssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.domain.security.Menu;
import com.dssm.service.security.MenuService;

@Controller
public class FrameController extends BaseController {
    
	@Autowired
    private MenuService menuService;
	
    @RequestMapping(value="/frame/top", method=RequestMethod.GET)
    public String top() {
        return view("top");
    }

    @RequestMapping(value="/frame/left", method=RequestMethod.GET)
    public String left(ModelMap modelMap) {
    	List<Menu> menuList = menuService.queryAllTree(Boolean.TRUE);
    	modelMap.put("menuList", menuList);
    	return view("left");
    }
    
    @RequestMapping(value="/frame/middle", method=RequestMethod.GET)
    
    public String middle() {
        return view("middle");
    }
    
    @RequestMapping(value="/frame/right", method=RequestMethod.GET)
    public String right() {
        return view("right");
    }

}