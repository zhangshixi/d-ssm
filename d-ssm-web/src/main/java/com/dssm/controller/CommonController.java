package com.dssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController extends BaseController {

	/* ---- version ---- */
    @RequestMapping(value="/version", method=RequestMethod.GET)
    public String version() {
        return "version";
    }
    
    /* ---- error ---- */
    @RequestMapping(value="/error", method=RequestMethod.GET)
    public String errorPage(ModelMap modelMap, String message) {
    	modelMap.put("message", message);
    	return "error/error";
    }
    
    @RequestMapping(value="/error/403", method=RequestMethod.GET)
    public String error403() {
        return "error/403";
    }
    
    @RequestMapping(value="/error/404", method=RequestMethod.GET)
    public String error404() {
        return "error/404";
    }
    
    @RequestMapping(value="/error/500", method=RequestMethod.GET)
    public String error500() {
        return "error/500";
    }

}