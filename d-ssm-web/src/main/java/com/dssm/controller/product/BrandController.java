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
import com.dssm.domain.product.Brand;
import com.dssm.service.product.BrandService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController {

	@Autowired
    private BrandService brandService;
	
	@RequiresPermissions("brand:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("brand:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Brand brand) {
		brand.setUpdateAdmin(getLoginAdmin());
	    brandService.add(brand);
	    
		return redirectTo("/brand");
	}
	
	@RequiresPermissions("brand:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Brand targetProductBrand = brandService.findById(id);
	    modelMap.put("target", targetProductBrand);
	    
		return view("show");
	}

	@RequiresPermissions("brand:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Brand brand = brandService.findById(id);
	    if (brand == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", brand);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("brand:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Brand brand) {
	    brand.setId(id);
	    brandService.editSelective(brand);
	    
		return redirectTo("/brand/{0}", id);
	}
	
	@RequiresPermissions("brand:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		brandService.removeById(id);
		
	    return redirectTo("/brand");
	}
	
	@RequiresPermissions("brand:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("brand:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Brand> page, Brand brand, ModelMap modelMap) {
		List<Brand> brandList = brandService.queryByPage(page, brand);
		modelMap.put("page", page);
		modelMap.put("resultList", brandList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return brandService.findByCode(code) == null;
	}
	
}
