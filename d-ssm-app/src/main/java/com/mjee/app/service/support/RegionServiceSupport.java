package com.mjee.app.service.support;

import com.mjee.app.domain.Region;
import com.mjee.app.service.AbstractService;
import com.mjee.app.service.RegionService;

public class RegionServiceSupport extends AbstractService implements RegionService {

    @Override
    public int addRegion(Region region) {
        return 0;
    }

    @Override
    public int removeRegion(int regionId) {
        return 0;
    }

    @Override
    public int editRegion(Region region) {
        return 0;
    }

    @Override
    public Region findRegionById(int regionId) {
        return null;
    }

}
