package com.dssm.mapper.product;

import java.util.List;

import com.dssm.domain.product.Brand;
import com.dssm.mapper.BaseMapper;

public interface BrandMapper extends BaseMapper<Brand> {
    
	public Brand selectByCode(String code);
	
    public List<Brand> selectAll();
    
}
