package com.dssm.controller.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.domain.product.Category;
import com.dssm.service.product.CategoryService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
    
	@Autowired
    private CategoryService categoryService;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Category category) {
		category.setUpdateAdmin(getLoginAdmin());
	    categoryService.add(category);
	    
		return redirectTo("/category");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Category targetCategory = categoryService.findById(id);
	    modelMap.put("target", targetCategory);
	    
		return view("show");
	}

	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Category category = categoryService.findById(id);
	    if (category == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", category);
	        return view("edit");
	    }
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Category category) {
	    category.setId(id);
	    category.setUpdateAdmin(getLoginAdmin());
	    categoryService.editSelective(category);
	    
		return redirectTo("/category/{0}", id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		categoryService.removeById(id);
		
	    return redirectTo("/category");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return view("index");
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Category> page, Category category, ModelMap modelMap) {
//		List<Category> categoryList = categoryService.queryByPage(page, category);
//		modelMap.put("page", page);
		
		List<Category> categoryList = categoryService.queryAllTree(null);
		modelMap.put("resultList", categoryList);
		
		return view("list");
	}
	
}