package com.dssm.service.setting;

import java.util.List;

import com.dssm.domain.setting.Shop;
import com.dssm.service.BaseService;

public interface ShopService extends BaseService<Shop> {
	
	public Shop findByCode(String code);
    
    public List<Shop> queryAll();

}
