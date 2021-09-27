package com.kpi.railwaystation.Factory;

import com.kpi.railwaystation.DAO.*;
import com.kpi.railwaystation.DAO.impl.postgres.*;
import com.kpi.railwaystation.db.ConnectionPool;
import com.kpi.railwaystation.db.PoolConnectionBuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLFactory extends DAOFactory {
    private Connection connection;

    public Connection createConnection() throws IOException, SQLException {
        this.connection = ConnectionPool.getInstance().getConnection();
        return this.connection;
    }

    @Override
    public PostgresCustomerDAO getCustomerDAO() throws SQLException, IOException {
        return new PostgresCustomerDAO(createConnection());
    }

    @Override
    public PostgresOrderDAO getOrderDAO() throws SQLException, IOException {
        return new PostgresOrderDAO(createConnection());
    }

    @Override
    public PostgresPlatformDAO getPlatformDAO() throws SQLException, IOException {
        return new PostgresPlatformDAO(createConnection());
    }

    @Override
    public PostgresSeatDAO getSeatDAO() throws SQLException, IOException {
        return new PostgresSeatDAO(createConnection());
    }

    @Override
    public PostgresTrainDAO getTrainDAO() throws SQLException, IOException {
        return new PostgresTrainDAO(createConnection());
    }
}