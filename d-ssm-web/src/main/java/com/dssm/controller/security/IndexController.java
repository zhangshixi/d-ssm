package com.dssm.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.domain.security.Menu;
import com.dssm.service.security.MenuService;

@Controller
public class IndexController extends BaseController {
    
	@Autowired
    private MenuService menuService;
	
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index() {
        return "back/index";
    }
    
    @RequestMapping(value="/top", method=RequestMethod.GET)
    public String top() {
        return "back/frame/top";
    }

    @RequestMapping(value="/left", method=RequestMethod.GET)
    public String left(ModelMap modelMap) {
    	List<Menu> menuList = menuService.queryAllTree(Boolean.TRUE);
    	System.err.println("menuList:  " + menuList);
    	modelMap.put("menuList", menuList);
    	return "back/frame/left";
    }
    
    @RequestMapping(value="/middle", method=RequestMethod.GET)
    
    public String middle() {
        return "back/frame/middle";
    }
    
    @RequestMapping(value="/right", method=RequestMethod.GET)
    public String right() {
        return "back/frame/right";
    }

}