package com.kpi.railwaystation.DAO.impl.postgres;

import com.kpi.railwaystation.DAO.PlatformDAO;
import com.kpi.railwaystation.db.ConnectionPool;
import com.kpi.railwaystation.model.Platform;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresPlatformDAO implements PlatformDAO {
    private Connection connection;

    public PostgresPlatformDAO(Connection connection){
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

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
