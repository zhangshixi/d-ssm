package com.dssm.service.depot;

import java.util.List;

import com.dssm.domain.depot.TransType;
import com.dssm.service.BaseService;

public interface TransTypeService extends BaseService<TransType> {
	
	public TransType findByCode(String code);
    
    public List<TransType> queryAll();

}
