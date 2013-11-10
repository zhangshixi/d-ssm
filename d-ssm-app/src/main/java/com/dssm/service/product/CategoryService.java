package com.dssm.service.product;

import java.util.List;

import com.dssm.domain.product.Category;
import com.dssm.service.BaseService;

public interface CategoryService extends BaseService<Category> {

	public Category findByCode(String code);

	public List<Category> queryAll(Boolean display);
	
	public List<Category> queryAllTree(Boolean display);
	
}
