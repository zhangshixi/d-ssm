package com.dssm.service.website;

import com.dssm.domain.website.Region;
import com.dssm.service.BaseService;

public interface RegionService extends BaseService {
    
    public int addRegion(Region region);

    public int removeRegion(Long regionId);

    public int editRegion(Region region);

    public Region findRegionById(Long regionId);
    
}
