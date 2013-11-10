package com.dssm.controller.setting;

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
import com.dssm.domain.setting.Platform;
import com.dssm.service.setting.PlatformService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/platform")
public class PlatformController extends BaseController {

	@Autowired
    private PlatformService platformService;
	
	@RequiresPermissions("platform:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("platform:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Platform platform) {
	    platformService.add(platform);
	    
		return redirectTo("/platform");
	}
	
	@RequiresPermissions("platform:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Platform targetProductPlatform = platformService.findById(id);
	    modelMap.put("target", targetProductPlatform);
	    
		return view("show");
	}

	@RequiresPermissions("platform:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Platform platform = platformService.findById(id);
	    if (platform == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", platform);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("platform:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Platform platform) {
	    platform.setId(id);
	    platformService.editSelective(platform);
	    
		return redirectTo("/platform/{0}", id);
	}
	
	@RequiresPermissions("platform:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		platformService.removeById(id);
		
	    return redirectTo("/platform");
	}
	
	@RequiresPermissions("platform:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("platform:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Platform> page, Platform platform, ModelMap modelMap) {
		List<Platform> platformList = platformService.queryByPage(page, platform);
		modelMap.put("page", page);
		modelMap.put("resultList", platformList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return platformService.findByCode(code) == null;
	}
	
}
