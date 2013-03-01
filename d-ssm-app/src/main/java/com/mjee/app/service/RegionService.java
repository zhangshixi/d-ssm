package com.mjee.app.service;

import com.mjee.app.domain.Region;

public interface RegionService extends BaseService {
    
    public int addRegion(Region region);

    public int removeRegion(int regionId);

    public int editRegion(Region region);

    public Region findRegionById(int regionId);
    
}
