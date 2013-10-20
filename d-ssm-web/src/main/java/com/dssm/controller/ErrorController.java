package com.dssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {

    @RequestMapping(method=RequestMethod.GET)
    public String errorPage(ModelMap modelMap, String message) {
    	modelMap.put("message", message);
    	return view("error");
    }
    
    @RequestMapping(value="/403", method=RequestMethod.GET)
    public String error403() {
        return view("403");
    }
    
    @RequestMapping(value="/404", method=RequestMethod.GET)
    public String error404() {
        return view("404");
    }
    
    @RequestMapping(value="/500", method=RequestMethod.GET)
    public String error500() {
        return view("500");
    }

}