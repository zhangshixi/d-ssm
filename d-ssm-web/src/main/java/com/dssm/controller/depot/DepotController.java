package com.dssm.controller.depot;

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
import com.dssm.domain.depot.Depot;
import com.dssm.service.depot.DepotService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/depot")
public class DepotController extends BaseController {

	@Autowired
    private DepotService depotService;
	
	@RequiresPermissions("depot:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("depot:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Depot depot) {
		depot.setUpdateAdmin(getLoginAdmin());
	    depotService.add(depot);
	    
		return redirectTo("/depot");
	}
	
	@RequiresPermissions("depot:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Depot targetProductDepot = depotService.findById(id);
	    modelMap.put("target", targetProductDepot);
	    
		return view("show");
	}

	@RequiresPermissions("depot:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Depot depot = depotService.findById(id);
	    if (depot == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", depot);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("depot:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Depot depot) {
	    depot.setId(id);
	    depotService.editSelective(depot);
	    
		return redirectTo("/depot/{0}", id);
	}
	
	@RequiresPermissions("depot:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		depotService.removeById(id);
		
	    return redirectTo("/depot");
	}
	
	@RequiresPermissions("depot:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("depot:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Depot> page, Depot depot, ModelMap modelMap) {
		List<Depot> depotList = depotService.queryByPage(page, depot);
		modelMap.put("page", page);
		modelMap.put("resultList", depotList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return depotService.findByCode(code) == null;
	}
	
}
