package com.dssm.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dssm.controller.BaseController;
import com.dssm.service.security.AdminService;

@Controller
@RequestMapping("/cache")
public class CacheController extends BaseController {
	
	@Autowired
	private AdminService adminService;
	
	
	
}
