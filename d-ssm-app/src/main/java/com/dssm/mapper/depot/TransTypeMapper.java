package com.dssm.mapper.depot;

import java.util.List;

import com.dssm.domain.depot.TransType;
import com.dssm.mapper.BaseMapper;

public interface TransTypeMapper extends BaseMapper<TransType> {
    
	public TransType selectByCode(String code);
	
    public List<TransType> selectAll();
    
}
