package com.mjee.service.website;

import com.mjee.domain.website.Region;
import com.mjee.service.BaseService;

public interface RegionService extends BaseService {
    
    public int addRegion(Region region);

    public int removeRegion(int regionId);

    public int editRegion(Region region);

    public Region findRegionById(int regionId);
    
}
