package com.dssm.mapper.depot;

import java.util.List;

import com.dssm.domain.depot.Depot;
import com.dssm.mapper.BaseMapper;

public interface DepotMapper extends BaseMapper<Depot> {
    
	public Depot selectByCode(String code);
	
    public List<Depot> selectAll();
    
}
