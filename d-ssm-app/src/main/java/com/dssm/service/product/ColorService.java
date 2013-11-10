package com.dssm.service.product;

import java.util.List;

import com.dssm.domain.product.Color;
import com.dssm.service.BaseService;

public interface ColorService extends BaseService<Color> {
	
	public Color findByCode(String code);
    
    public List<Color> queryAll();

}
