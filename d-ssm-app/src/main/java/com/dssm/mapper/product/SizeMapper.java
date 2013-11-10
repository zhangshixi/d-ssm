package com.dssm.mapper.product;

import java.util.List;

import com.dssm.domain.product.Size;
import com.dssm.mapper.BaseMapper;

public interface SizeMapper extends BaseMapper<Size> {
    
	public Size selectByCode(String code);
	
    public List<Size> selectAll();
    
}
