package com.dssm.service.website.support;

import org.springframework.beans.factory.annotation.Autowired;

import com.dssm.domain.website.Region;
import com.dssm.mapper.website.RegionMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.website.RegionService;

public class RegionServiceSupport extends AbstractService implements RegionService {

    @Autowired
    private RegionMapper regionMapper;
    
    @Override
    public void init() {
        super.init();
        
    }
    
    @Override
    public int addRegion(Region region) {
        return regionMapper.insert(region);
    }

    @Override
    public int removeRegion(int regionId) {
        return regionMapper.deleteById(regionId);
    }

    @Override
    public int editRegion(Region region) {
        return regionMapper.updateSelective(region);
    }

    @Override
    public Region findRegionById(int regionId) {
        return regionMapper.selectById(regionId);
    }

}
