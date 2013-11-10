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
import com.dssm.domain.depot.TransType;
import com.dssm.service.depot.TransTypeService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/transtype")
public class TransTypeController extends BaseController {

	@Autowired
    private TransTypeService transTypeService;
	
	@RequiresPermissions("transtype:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("transtype:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid TransType transType) {
		transType.setUpdateAdmin(getLoginAdmin());
	    transTypeService.add(transType);
	    
		return redirectTo("/transtype");
	}
	
	@RequiresPermissions("transtype:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		TransType targetProductTransType = transTypeService.findById(id);
	    modelMap.put("target", targetProductTransType);
	    
		return view("show");
	}

	@RequiresPermissions("transtype:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		TransType transType = transTypeService.findById(id);
	    if (transType == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", transType);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("transtype:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, TransType transType) {
	    transType.setId(id);
	    transTypeService.editSelective(transType);
	    
		return redirectTo("/transtype/{0}", id);
	}
	
	@RequiresPermissions("transtype:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		transTypeService.removeById(id);
		
	    return redirectTo("/transtype");
	}
	
	@RequiresPermissions("transtype:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("transtype:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<TransType> page, TransType transType, ModelMap modelMap) {
		List<TransType> transTypeList = transTypeService.queryByPage(page, transType);
		modelMap.put("page", page);
		modelMap.put("resultList", transTypeList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return transTypeService.findByCode(code) == null;
	}
	
}
