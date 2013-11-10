package com.dssm.mapper.product;

import java.util.List;

import com.dssm.domain.product.Color;
import com.dssm.mapper.BaseMapper;

public interface ColorMapper extends BaseMapper<Color> {
    
	public Color selectByCode(String code);
	
    public List<Color> selectAll();
    
}
