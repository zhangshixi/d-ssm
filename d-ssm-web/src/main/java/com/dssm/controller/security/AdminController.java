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
import com.dssm.domain.security.Admin;
import com.dssm.service.security.AdminService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到添加管理员页面。
     */
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String toAdd() {
        return "back/admin/add";
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
	    Admin admin = adminService.findById(id);
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
	    
		return "back/admin/show";
	}
	
	/**
	 * 查询管理员信息列表。
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "back/admin/index";
	}
	
	/**
	 * 分页查询管理员信息列表。
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Admin> page, Admin admin, ModelMap modelMap) {
		List<Admin> adminList = adminService.queryByPage(page, admin);
		modelMap.put("page", page);
		modelMap.put("resultList", adminList);
		
		return "back/admin/list";
	}
	
	
	/* ~~~~ check methods ~~~~ */
	@ResponseBody
	@RequestMapping(value="/check/name", method=RequestMethod.GET)
	public boolean checkName(String name) {
		return adminService.findByLoginName(name) == null;
	}
	
}