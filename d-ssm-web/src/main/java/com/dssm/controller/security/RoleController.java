package com.dssm.controller.security;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dssm.controller.BaseController;
import com.dssm.domain.security.Permission;
import com.dssm.domain.security.Role;
import com.dssm.service.security.PermissionService;
import com.dssm.service.security.RoleService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    
	@Autowired
    private RoleService roleService;
	@Autowired
    private PermissionService permissionService;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return "back/role/add";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Role role) {
	    roleService.add(role);
	    
		return redirectTo("/role");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Role targetRole = roleService.findById(id);
	    modelMap.put("target", targetRole);
	    
		return "back/role/show";
	}

	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Role role = roleService.findById(id);
	    if (role == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", role);
	        return "back/role/edit";
	    }
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Role role) {
	    role.setId(id);
	    roleService.editSelective(role);
	    
		return redirectTo("/role/{0}", id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		roleService.removeById(id);
		
	    return redirectTo("/role");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "back/role/index";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Role> page, Role role, ModelMap modelMap) {
		List<Role> roleList = roleService.queryByPage(page, role);
		modelMap.put("page", page);
		modelMap.put("resultList", roleList);
		
		return "back/role/list";
	}
	
	@RequestMapping(value="{id}/authorize", method=RequestMethod.GET)
	public String toAuthorize(@PathVariable Integer id, ModelMap modelMap) {
		Role role = roleService.findById(id);
		List<Permission> allPermissionList = permissionService.queryAll();
		List<Permission> ownPermissionList = permissionService.queryAll(id);

		modelMap.put("role", role);
		modelMap.put("allPermissionList", allPermissionList);
		modelMap.put("ownPermissionList", ownPermissionList);
		
		return "back/role/authorize";
	}

	@RequestMapping(value="{id}/authorize", method=RequestMethod.PUT)
	public String authorize(@PathVariable Integer id, Role role) {
		
		
		return "back/role/authorize";
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return roleService.findByCode(code) == null;
	}
	
}