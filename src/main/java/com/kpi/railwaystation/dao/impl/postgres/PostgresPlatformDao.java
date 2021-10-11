package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.PlatformDao;
import com.kpi.railwaystation.model.Platform;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresPlatformDao implements PlatformDao {
    private Connection connection;

    public PostgresPlatformDao(Connection connection){
        this.connection = connection;
    }
    @Override
    public Platform createPlatform() {
        return null;
    }

    @Override
    public Platform readPlatform() {
        return null;
    }

    @Override
    public Platform updatePlatform() {
        return null;
    }

    @Override
    public Platform deletePlatform() {
        return null;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
