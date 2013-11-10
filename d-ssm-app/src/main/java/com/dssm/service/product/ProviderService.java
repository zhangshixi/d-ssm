package com.dssm.service.product;

import java.util.List;

import com.dssm.domain.product.Provider;
import com.dssm.service.BaseService;

public interface ProviderService extends BaseService<Provider> {
	
	public Provider findByCode(String code);
    
    public List<Provider> queryAll();

}
