package com.dssm.service.setting;

import java.util.List;

import com.dssm.domain.setting.Platform;
import com.dssm.service.BaseService;

public interface PlatformService extends BaseService<Platform> {
	
	public Platform findByCode(String code);
    
    public List<Platform> queryAll(Boolean enable);

}
