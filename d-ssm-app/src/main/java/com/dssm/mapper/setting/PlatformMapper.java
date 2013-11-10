package com.dssm.mapper.setting;

import java.util.List;

import com.dssm.domain.setting.Platform;
import com.dssm.mapper.BaseMapper;

public interface PlatformMapper extends BaseMapper<Platform> {
    
	public Platform selectByCode(String code);
	
    public List<Platform> selectAll(Boolean enable);
    
}
