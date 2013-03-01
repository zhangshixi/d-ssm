package com.mjee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjee.app.domain.Role;

@Controller
public class RoleController extends AbstractController {
    
    @RequestMapping(value="/role", method=RequestMethod.GET)
    public String showRoleList() {
        return null;
    }

	@RequestMapping(value="/role/new", method=RequestMethod.GET)
	public String toNewRole() {
		return null;
	}
	
	@RequestMapping(value="/role", method=RequestMethod.POST)
	public String newRole(Role role) {
	    return null;
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.GET)
	public String showRole(@PathVariable int id) {
	    return null;
	}

	@RequestMapping(value="/role/{id}", method=RequestMethod.PUT)
	public String editRole(@PathVariable int id, Role role) {
		return null;
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.DELETE)
	public String removeRole(@PathVariable int id) {
		return null;
	}
	
}