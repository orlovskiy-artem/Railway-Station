package com.kpi.railwaystation.factory;

import com.kpi.railwaystation.dao.impl.postgres.*;
import com.kpi.railwaystation.db.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLFactory extends DaoFactory {
    private Connection connection;

    public Connection createConnection() throws IOException, SQLException {
        this.connection = ConnectionPool.getInstance().getConnection();
        return this.connection;
    }

    @Override
    public PostgresCustomerDao getCustomerDao() throws SQLException, IOException {
        return new PostgresCustomerDao(createConnection());
    }

    @Override
    public PostgresOrderDao getOrderDao() throws SQLException, IOException {
        return new PostgresOrderDao(createConnection());
    }

    @Override
    public PostgresPlatformDao getPlatformDao() throws SQLException, IOException {
        return new PostgresPlatformDao(createConnection());
    }

    @Override
    public PostgresSeatDao getSeatDao() throws SQLException, IOException {
        return new PostgresSeatDao(createConnection());
    }

    @Override
    public PostgresTrainDao getTrainDao() throws SQLException, IOException {
        return new PostgresTrainDao(createConnection());
    }
}