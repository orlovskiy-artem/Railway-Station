package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Platform;

import java.sql.SQLException;

public interface PlatformDao {
    public Platform createPlatform() throws SQLException;
    public Platform readPlatform() throws SQLException;
    public Platform updatePlatform() throws SQLException;
    public Platform deletePlatform() throws SQLException;
}
