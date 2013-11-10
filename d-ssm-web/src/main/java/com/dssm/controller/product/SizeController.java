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
import com.dssm.domain.product.Size;
import com.dssm.service.product.SizeService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/size")
public class SizeController extends BaseController {

	@Autowired
    private SizeService sizeService;
	
	@RequiresPermissions("size:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("size:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Size size) {
		size.setUpdateAdmin(getLoginAdmin());
	    sizeService.add(size);
	    
		return redirectTo("/size");
	}
	
	@RequiresPermissions("size:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Size targetProductSize = sizeService.findById(id);
	    modelMap.put("target", targetProductSize);
	    
		return view("show");
	}

	@RequiresPermissions("size:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Size size = sizeService.findById(id);
	    if (size == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", size);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("size:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Size size) {
	    size.setId(id);
	    sizeService.editSelective(size);
	    
		return redirectTo("/size/{0}", id);
	}
	
	@RequiresPermissions("size:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		sizeService.removeById(id);
		
	    return redirectTo("/size");
	}
	
	@RequiresPermissions("size:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("size:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Size> page, Size size, ModelMap modelMap) {
		List<Size> sizeList = sizeService.queryByPage(page, size);
		modelMap.put("page", page);
		modelMap.put("resultList", sizeList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return sizeService.findByCode(code) == null;
	}
	
}
