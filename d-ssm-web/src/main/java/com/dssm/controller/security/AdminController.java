package com.dssm.controller.security;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dssm.controller.BaseController;
import com.dssm.domain.security.Admin;
import com.dssm.domain.security.Role;
import com.dssm.service.security.AdminService;
import com.dssm.service.security.RoleService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService  roleService;

    /**
     * 跳转到添加管理员页面。
     */
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String toAdd() {
        return view("add");
    }
    
    /**
     * 添加管理员。
     */
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Admin admin) {
		admin.setCreateAid(getLoginAdminId());
	    adminService.add(admin);
	    
		return redirectTo("/admin");
	}
	
	/**
	 * 跳转到编辑管理员信息页面。
	 */
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
	    Admin targetAdmin = adminService.findById(id);
	    if (targetAdmin == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", targetAdmin);
	        return view("edit");
	    }
	}
	
	/**
	 * 编辑管理员。
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Admin admin) {
	    admin.setId(id);
	    adminService.editSelective(admin);
	    
		return redirectTo("/admin/{0}", id);
	}
	
	/**
	 * 删除管理员。
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
	    adminService.removeById(id);
		
	    return redirectTo("/admin");
	}
	
	/**
	 * 查询指定管理员信息。
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
	    Admin targetAdmin = adminService.findById(id);
	    modelMap.put("target", targetAdmin);
	    
		return view("show");
	}
	
	/**
	 * 查询管理员信息列表。
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return view("index");
	}
	
	/**
	 * 分页查询管理员信息列表。
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Admin> page, Admin admin, ModelMap modelMap) {
		List<Admin> adminList = adminService.queryByPage(page, admin);
		modelMap.put("page", page);
		modelMap.put("resultList", adminList);
		
		return view("list");
	}
	
	/**
	 * 跳转到修改密码页面。
	 */
	@RequestMapping(value="{id}/password", method=RequestMethod.GET)
	public String toEditPassword(@PathVariable Integer id, ModelMap modelMap) {
		Admin targetAdmin = adminService.findById(id);
		if (targetAdmin == null) {
			return redirectTo("/error/404");
		} else if (!SecurityUtils.getSubject().isAuthenticated()) {
			return redirectTo("/logout");
		}
		
		modelMap.put("target", targetAdmin);
		return view("password");
	}
	
	/**
	 * 修改密码。
	 */
	@RequestMapping(value="{id}/password", method=RequestMethod.PUT)
	public String editPassword(@PathVariable Integer id, ModelMap modelMap) {
		
		return redirectTo("/admin/{0}", id);
	}
	
	
	/**
	 * 跳转到分配角色页面。
	 */
	@RequestMapping(value="{id}/authorize", method=RequestMethod.GET)
	public String toAuthorize(@PathVariable Integer id, ModelMap modelMap) {
		Admin targetAdmin = adminService.findById(id);
		if (targetAdmin == null) {
	        return redirectTo("/error/404");
	    }
		
    	List<Role> ownRoleList = roleService.queryAll(id);
    	List<Role> allRoleList = roleService.queryAll();
    	
        modelMap.put("target", targetAdmin);
        modelMap.put("ownRoleList", ownRoleList);
        modelMap.put("allRoleList", allRoleList);
        
        return view("authorize");
	}
	
	/**
	 * 分配角色。
	 */
	@RequestMapping(value="{id}/authorize", method=RequestMethod.POST)
	public String authorize(@PathVariable Integer id, ModelMap modelMap) {
		
		return redirectTo("/admin/{0}/authorize", id);
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/name", method=RequestMethod.GET)
	public boolean checkName(String name) {
		return adminService.findByLoginName(name) == null;
	}
	
	/* ---- private methods ---- */
	private String view(String viewName) {
		return "back/admin/" + viewName;
	}
	
}