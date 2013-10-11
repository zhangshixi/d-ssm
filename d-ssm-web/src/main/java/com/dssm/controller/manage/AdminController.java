package com.dssm.controller.manage;

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
import com.dssm.domain.manage.Admin;
import com.dssm.service.manage.AdminService;
import com.mtoolkit.page.Page;

@Controller
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到添加管理员页面。
     */
    @RequestMapping(value="/admin/new", method=RequestMethod.GET)
    public String toNewAdmin() {
        return "back/admin/add";
    }
    
    /**
     * 添加管理员。
     */
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public String newAdmin(@Valid Admin admin) {
		admin.setCreateAid(getLoginAdminId());
	    adminService.addAdmin(admin);
	    
		return redirectTo("/admin");
	}
	
	/**
	 * 跳转到编辑管理员信息页面。
	 */
	@RequestMapping(value="/admin/{id}/edit", method=RequestMethod.GET)
	public String toEditAdmin(@PathVariable Long id, ModelMap modelMap) {
	    Admin admin = adminService.findAdminById(id);
	    if (admin == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", admin);
	        return "back/admin/edit";
	    }
	}
	
	/**
	 * 编辑管理员。
	 */
	@RequestMapping(value="/admin/{id}", method=RequestMethod.PUT)
	public String editAdmin(@PathVariable Long id, Admin admin) {
	    admin.setId(id);
	    adminService.editAdmin(admin);
	    
		return redirectTo("/admin/{0}", id);
	}
	
	/**
	 * 删除管理员。
	 */
	@RequestMapping(value="/admin/{id}", method=RequestMethod.DELETE)
	public String removeAdmin(@PathVariable Long id) {
	    adminService.removeAdmin(id);
		
	    return redirectTo("/admin");
	}
	
	/**
	 * 查询指定管理员信息。
	 */
	@RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
	public String showAdmin(@PathVariable Long id, ModelMap modelMap) {
	    Admin targetAdmin = adminService.findAdminById(id);
	    modelMap.put("target", targetAdmin);
	    
		return "back/admin/show";
	}
	
	/**
	 * 查询管理员信息列表。
	 */
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "back/admin/index";
	}
	
	/**
	 * 分页查询管理员信息列表。
	 */
	@RequestMapping(value="/admin/list", method=RequestMethod.POST)
	public String showAdminList(Page<Admin> page, Admin admin, ModelMap modelMap) {
		List<Admin> adminList = adminService.queryAdminsByPage(page, admin);
		modelMap.put("page", page);
		modelMap.put("adminList", adminList);
		
		return "back/admin/list";
	}
	
	
	/* ~~~~ check methods ~~~~ */
	@ResponseBody
	@RequestMapping(value="/admin/check/name", method=RequestMethod.GET)
	public boolean checkAdminName(String name) {
		return adminService.findAdminByLoginName(name) == null;
	}
	
}