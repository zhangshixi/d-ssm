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
import com.dssm.domain.setting.Shop;
import com.dssm.service.setting.PlatformService;
import com.dssm.service.setting.ShopService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {

	@Autowired
    private ShopService shopService;
	@Autowired
	private PlatformService platformService;
	
	@RequiresPermissions("shop:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd(ModelMap modelMap) {
		modelMap.put("platformList", platformService.queryAll(Boolean.TRUE));
		return view("add");
	}
	
	@RequiresPermissions("shop:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Shop shop) {
	    shopService.add(shop);
	    
		return redirectTo("/shop");
	}
	
	@RequiresPermissions("shop:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Shop targetProductShop = shopService.findById(id);
	    modelMap.put("target", targetProductShop);
	    
		return view("show");
	}

	@RequiresPermissions("shop:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Shop shop = shopService.findById(id);
	    if (shop == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", shop);
	        modelMap.put("platformList", platformService.queryAll(Boolean.TRUE));
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("shop:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Shop shop) {
	    shop.setId(id);
	    shopService.editSelective(shop);
	    
		return redirectTo("/shop/{0}", id);
	}
	
	@RequiresPermissions("shop:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		shopService.removeById(id);
		
	    return redirectTo("/shop");
	}
	
	@RequiresPermissions("shop:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("shop:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Shop> page, Shop shop, ModelMap modelMap) {
		List<Shop> shopList = shopService.queryByPage(page, shop);
		modelMap.put("page", page);
		modelMap.put("resultList", shopList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return shopService.findByCode(code) == null;
	}
	
}
