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
import com.dssm.domain.product.Color;
import com.dssm.service.product.ColorService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/color")
public class ColorController extends BaseController {

	@Autowired
    private ColorService colorService;
	
	@RequiresPermissions("color:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("color:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Color color) {
		color.setUpdateAdmin(getLoginAdmin());
	    colorService.add(color);
	    
		return redirectTo("/color");
	}
	
	@RequiresPermissions("color:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Color targetProductColor = colorService.findById(id);
	    modelMap.put("target", targetProductColor);
	    
		return view("show");
	}

	@RequiresPermissions("color:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Color color = colorService.findById(id);
	    if (color == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", color);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("color:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Color color) {
	    color.setId(id);
	    colorService.editSelective(color);
	    
		return redirectTo("/color/{0}", id);
	}
	
	@RequiresPermissions("color:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		colorService.removeById(id);
		
	    return redirectTo("/color");
	}
	
	@RequiresPermissions("color:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("color:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Color> page, Color color, ModelMap modelMap) {
		List<Color> colorList = colorService.queryByPage(page, color);
		modelMap.put("page", page);
		modelMap.put("resultList", colorList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return colorService.findByCode(code) == null;
	}
	
}
