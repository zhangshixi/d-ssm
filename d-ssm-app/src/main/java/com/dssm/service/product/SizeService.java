package com.dssm.service.product;

import java.util.List;

import com.dssm.domain.product.Size;
import com.dssm.service.BaseService;

public interface SizeService extends BaseService<Size> {
	
	public Size findByCode(String code);
    
    public List<Size> queryAll();

}
