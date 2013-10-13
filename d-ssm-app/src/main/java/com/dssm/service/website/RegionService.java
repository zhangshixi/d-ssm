package com.dssm.service.website;

import com.dssm.domain.website.Region;
import com.dssm.service.BaseService;

public interface RegionService extends BaseService<Region> {
    
    public Integer addRegion(Region region);

    public int removeRegion(Integer regionId);

    public int editRegion(Region region);

    public Region findRegionById(Integer regionId);
    
}
