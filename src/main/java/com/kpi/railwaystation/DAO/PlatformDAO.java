package com.kpi.railwaystation.DAO;

import com.kpi.railwaystation.model.Platform;

import java.sql.SQLException;

public interface PlatformDAO extends DAO {
    public Platform createPlatform();
    public Platform readPlatform();
    public Platform updatePlatform();
    public Platform deletePlatform();
}
