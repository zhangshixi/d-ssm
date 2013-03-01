package com.mjee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjee.app.domain.Permission;

@Controller
public class PermissionController extends AbstractController {

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
