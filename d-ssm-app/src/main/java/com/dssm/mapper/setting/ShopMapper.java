package com.dssm.mapper.setting;

import java.util.List;

import com.dssm.domain.setting.Shop;
import com.dssm.mapper.BaseMapper;

public interface ShopMapper extends BaseMapper<Shop> {
    
	public Shop selectByCode(String code);
	
    public List<Shop> selectAll();
    
}
