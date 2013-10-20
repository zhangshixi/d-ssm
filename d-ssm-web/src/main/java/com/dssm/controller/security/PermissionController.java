package com.dssm.controller.security;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dssm.controller.BaseController;
import com.dssm.domain.security.Permission;
import com.dssm.service.security.PermissionService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

	@Autowired
    private PermissionService permissionService;
	
	@RequiresPermissions("permission:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("permission:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Permission permission) {
	    permissionService.add(permission);
	    
		return redirectTo("/permission");
	}
	
	@RequiresPermissions("permission:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Permission targetPermission = permissionService.findById(id);
	    modelMap.put("target", targetPermission);
	    
		return view("show");
	}

	@RequiresPermissions("permission:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Permission permission = permissionService.findById(id);
	    if (permission == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", permission);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("permission:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Permission permission) {
	    permission.setId(id);
	    permissionService.editSelective(permission);
	    
		return redirectTo("/permission/{0}", id);
	}
	
	@RequiresPermissions("permission:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		permissionService.removeById(id);
		
	    return redirectTo("/permission");
	}
	
	@RequiresPermissions("permission:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return view("index");
	}
	
	@RequiresPermissions("permission:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Permission> page, Permission permission, ModelMap modelMap) {
		List<Permission> permissionList = permissionService.queryByPage(page, permission);
		modelMap.put("page", page);
		modelMap.put("resultList", permissionList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return permissionService.findByCode(code) == null;
	}
	
}
