package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Platform;

public interface PlatformDao {
    public Platform createPlatform();
    public Platform readPlatform();
    public Platform updatePlatform();
    public Platform deletePlatform();
}
