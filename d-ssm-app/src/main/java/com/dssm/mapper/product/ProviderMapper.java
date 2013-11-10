package com.dssm.mapper.product;

import java.util.List;

import com.dssm.domain.product.Provider;
import com.dssm.mapper.BaseMapper;

public interface ProviderMapper extends BaseMapper<Provider> {
    
	public Provider selectByCode(String code);
	
    public List<Provider> selectAll();
    
}
