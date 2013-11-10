package com.dssm.service.setting.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.setting.Platform;
import com.dssm.mapper.setting.PlatformMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.setting.PlatformService;
import com.mtoolkit.page.Page;

@Service
public class PlatformServiceSupport extends AbstractService<Platform> implements PlatformService {

	@Autowired
    private PlatformMapper platformMapper;

	@Override
    public Integer add(Platform platform) {
        return platformMapper.insert(platform);
    }

    @Override
    public int removeById(Integer platformId) {
        return platformMapper.deleteById(platformId);
    }

    @Override
    public int editSelective(Platform platform) {
        return platformMapper.updateSelective(platform);
    }

    @Override
    public Platform findById(Integer platformId) {
        return platformMapper.selectById(platformId);
    }

    @Override
    public Platform findByCode(String code) {
        return platformMapper.selectByCode(code);
    }
    
    @Override
    public List<Platform> queryByPage(Page<Platform> page, Platform search) {
    	return platformMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Platform> queryAll(Boolean enable) {
		return platformMapper.selectAll(enable);
	}

}
