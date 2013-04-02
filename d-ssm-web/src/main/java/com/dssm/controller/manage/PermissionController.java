package com.dssm.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.domain.manage.Permission;

@Controller
public class PermissionController extends BaseController {

	@RequestMapping(value="/permission", method=RequestMethod.POST)
	public String createPermission(Permission permission) {
		return null;
	}

	@RequestMapping(value="/permission", method=RequestMethod.PUT)
	public String editPermission(Permission permission) {
		return null;
	}
	
	@RequestMapping(value="/permission/{id}", method=RequestMethod.DELETE)
	public String removePermission(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value="/permission/{id}", method=RequestMethod.GET)
	public String showPermission(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value="/permission", method=RequestMethod.GET)
	public String showPermissionList() {
		return null;
	}
	
}
