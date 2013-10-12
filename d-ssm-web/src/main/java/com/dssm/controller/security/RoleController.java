package com.dssm.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.domain.security.Role;
import com.dssm.exception.BusinessException;
import com.dssm.exception.NotFoundException;
import com.dssm.exception.SystemException;

@Controller
public class RoleController extends BaseController {
    
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
	public String showRole(@PathVariable Long id) {
		if (id == 1) {
			throw new SystemException("system exception test...");
		}
		else if (id == 2) {
			throw new BusinessException("business exception test...");
		}
		else if (id == 3) {
			throw new NotFoundException("not found exception test...");
		}
		else {
			return null;
		}
	}

	@RequestMapping(value="/role/{id}", method=RequestMethod.PUT)
	public String editRole(@PathVariable Long id, Role role) {
		return null;
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.DELETE)
	public String removeRole(@PathVariable Long id) {
		return null;
	}
	
}