package com.mjee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController extends BaseController {

    @RequestMapping(value="/version", method=RequestMethod.GET)
    public String version() {
        return "version";
    }
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index() {
        return "redirect:/login";
    }
    
    @RequestMapping(value="/403", method=RequestMethod.GET)
    public String error403() {
        return "error/403";
    }
    
    @RequestMapping(value="/404", method=RequestMethod.GET)
    public String error404() {
        return "error/404";
    }
    
    @RequestMapping(value="/500", method=RequestMethod.GET)
    public String error500() {
        return "error/500";
    }
    	
}