package com.dssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends BaseController {

	/* ---- index ---- */
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String index() {
        return "index";
    }
	
	/* ---- version ---- */
    @RequestMapping(value="/version", method=RequestMethod.GET)
    public String version() {
        return "version";
    }
    
    @RequestMapping(value="/kind", method=RequestMethod.GET)
    public String editor() {
        return "editor/demo";
    }
    

    @RequestMapping(value="/editor/file_manager_json", method=RequestMethod.GET)
    public String file_manager_json() {
        return "editor/file_manager_json";
    }
    
//    @RequestMapping(value="/editor/upload_json", method=RequestMethod.POST)
//    public String upload_json() {
//        return "editor/upload_json";
//    }
    
}