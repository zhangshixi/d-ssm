package com.dssm.service.product;

import java.util.List;

import com.dssm.domain.product.Brand;
import com.dssm.service.BaseService;

public interface BrandService extends BaseService<Brand> {
	
	public Brand findByCode(String code);
    
    public List<Brand> queryAll();

}
