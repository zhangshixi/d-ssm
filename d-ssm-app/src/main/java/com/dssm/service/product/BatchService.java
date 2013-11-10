package com.dssm.service.product;

import java.util.List;

import com.dssm.domain.product.Batch;
import com.dssm.service.BaseService;

public interface BatchService extends BaseService<Batch> {
	
	public Batch findByCode(String code);
    
    public List<Batch> queryAll();

}
