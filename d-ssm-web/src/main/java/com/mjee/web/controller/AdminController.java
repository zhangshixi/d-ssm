package com.mjee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjee.app.domain.Admin;
import com.mjee.app.service.AdminService;

@Controller
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    /**
     * 添加管理员页面。
     */
    @RequestMapping(value="/admin/create", method=RequestMethod.GET)
    public String toCreateAdmin() {
        return null;
    }
    
    /**
     * 添加管理员。
     */
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public String createAdmin(Admin admin) {
	    adminService.newAdmin(admin);
		return null;
	}
	
	/**
	 * 编辑管理员信息页面。
	 */
	@RequestMapping(value="/admin/{id}/edit", method=RequestMethod.GET)
	public String toEditAdmin(@PathVariable int id) {
	    return null;
	}
	
	/**
	 * 编辑管理员。
	 */
	@RequestMapping(value="/admin/{id}", method=RequestMethod.PUT)
	public String editAdmin(@PathVariable int id, Admin admin) {
	    admin.setId(id);
	    adminService.editAdmin(admin);
		return null;
	}
	
	/**
	 * 删除管理员。
	 */
	@RequestMapping(value="/admin/{id}", method=RequestMethod.DELETE)
	public String removeAdmin(@PathVariable int id) {
	    adminService.removeAdmin(id);
		return null;
	}
	
	/**
	 * 查询指定管理员信息。
	 */
	@RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
	public String showAdmin(@PathVariable int id, ModelMap modelMap) {
	    Admin targetAdmin = adminService.findAdminById(id);
	    modelMap.put("targetAdmin", targetAdmin);
		return null;
	}
	
	/**
	 * 查询管理员信息列表。
	 */
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdminList() {
		return null;
	}
	
}