package com.dssm.service.depot;

import java.util.List;

import com.dssm.domain.depot.Depot;
import com.dssm.service.BaseService;

public interface DepotService extends BaseService<Depot> {
	
	public Depot findByCode(String code);
    
    public List<Depot> queryAll();

}
