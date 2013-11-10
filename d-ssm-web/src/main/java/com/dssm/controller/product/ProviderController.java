package com.dssm.controller.product;

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
import com.dssm.domain.product.Provider;
import com.dssm.service.product.ProviderService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/provider")
public class ProviderController extends BaseController {

	@Autowired
    private ProviderService providerService;
	
	@RequiresPermissions("provider:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("provider:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Provider provider) {
		provider.setUpdateAdmin(getLoginAdmin());
	    providerService.add(provider);
	    
		return redirectTo("/provider");
	}
	
	@RequiresPermissions("provider:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Provider targetProductProvider = providerService.findById(id);
	    modelMap.put("target", targetProductProvider);
	    
		return view("show");
	}

	@RequiresPermissions("provider:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Provider provider = providerService.findById(id);
	    if (provider == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", provider);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("provider:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Provider provider) {
	    provider.setId(id);
	    provider.setUpdateAdmin(getLoginAdmin());
	    providerService.editSelective(provider);
	    
		return redirectTo("/provider/{0}", id);
	}
	
	@RequiresPermissions("provider:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		providerService.removeById(id);
		
	    return redirectTo("/provider");
	}
	
	@RequiresPermissions("provider:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("provider:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Provider> page, Provider provider, ModelMap modelMap) {
		List<Provider> providerList = providerService.queryByPage(page, provider);
		modelMap.put("page", page);
		modelMap.put("resultList", providerList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return providerService.findByCode(code) == null;
	}
	
}
