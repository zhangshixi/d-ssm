package com.dssm.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;

@Controller
public class IndexController extends BaseController {
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index() {
        return "back/index";
    }
    
    @RequestMapping(value="/top", method=RequestMethod.GET)
    public String top() {
        return "back/frame/top";
    }

    @RequestMapping(value="/left", method=RequestMethod.GET)
    public String left(ModelMap modelMap, String message) {
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