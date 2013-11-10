package com.dssm.mapper.product;

import java.util.List;

import com.dssm.domain.product.Category;
import com.dssm.mapper.BaseMapper;

public interface CategoryMapper extends BaseMapper<Category> {

	public Category selectByCode(String code);

	public List<Category> selectAll(Boolean display);
	
}