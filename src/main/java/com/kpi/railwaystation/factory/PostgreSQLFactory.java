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
    public PostgresUserDao getCustomerDao() throws SQLException, IOException {
        return new PostgresUserDao(createConnection());
    }

    @Override
    public PostgresTicketDao getOrderDao() throws SQLException, IOException {
        return new PostgresTicketDao(createConnection());
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