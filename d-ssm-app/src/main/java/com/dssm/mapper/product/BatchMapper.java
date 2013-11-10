package com.dssm.mapper.product;

import java.util.List;

import com.dssm.domain.product.Batch;
import com.dssm.mapper.BaseMapper;

public interface BatchMapper extends BaseMapper<Batch> {
    
	public Batch selectByCode(String code);
	
    public List<Batch> selectAll();
    
}
