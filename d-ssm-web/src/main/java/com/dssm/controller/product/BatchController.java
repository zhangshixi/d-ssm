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
import com.dssm.domain.product.Batch;
import com.dssm.service.product.BatchService;
import com.mtoolkit.page.Page;

@Controller
@RequestMapping("/batch")
public class BatchController extends BaseController {

	@Autowired
    private BatchService batchService;
	
	@RequiresPermissions("batch:new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String toAdd() {
		return view("add");
	}
	
	@RequiresPermissions("batch:new")
	@RequestMapping(method=RequestMethod.POST)
	public String add(@Valid Batch batch) {
		batch.setUpdateAdmin(getLoginAdmin());
	    batchService.add(batch);
	    
		return redirectTo("/batch");
	}
	
	@RequiresPermissions("batch:show")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Integer id, ModelMap modelMap) {
		Batch targetProductBatch = batchService.findById(id);
	    modelMap.put("target", targetProductBatch);
	    
		return view("show");
	}

	@RequiresPermissions("batch:edit")
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id, ModelMap modelMap) {
		Batch batch = batchService.findById(id);
	    if (batch == null) {
	        return redirectTo("/error/404");
	    } else {
	        modelMap.put("target", batch);
	        return view("edit");
	    }
	}
	
	@RequiresPermissions("batch:edit")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Batch batch) {
	    batch.setId(id);
	    batchService.editSelective(batch);
	    
		return redirectTo("/batch/{0}", id);
	}
	
	@RequiresPermissions("batch:remove")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String remove(@PathVariable Integer id) {
		//TODO: 已关联商品的品牌不能被删除
		batchService.removeById(id);
		
	    return redirectTo("/batch");
	}
	
	@RequiresPermissions("batch:show")
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String view = view("index");
		System.err.println(view);
		return view;
	}
	
	@RequiresPermissions("batch:show")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<Batch> page, Batch batch, ModelMap modelMap) {
		List<Batch> batchList = batchService.queryByPage(page, batch);
		modelMap.put("page", page);
		modelMap.put("resultList", batchList);
		
		return view("list");
	}
	
	
	/* ---- check methods ---- */
	@ResponseBody
	@RequestMapping(value="/check/code", method=RequestMethod.GET)
	public boolean checkCode(String code) {
		return batchService.findByCode(code) == null;
	}
	
}
