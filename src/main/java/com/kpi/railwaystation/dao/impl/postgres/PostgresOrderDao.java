package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.OrderDao;
import com.kpi.railwaystation.model.Order;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresOrderDao implements OrderDao {
    private Connection connection;

    public PostgresOrderDao(java.sql.Connection connection){
        this.connection = connection;
    }

    @Override
    public Order createOrder() {
        return null;
    }

    @Override
    public Order readOrder() {
        return null;
    }

    @Override
    public Order updateOrder() {
        return null;
    }

    @Override
    public Order deleteOrder() {
        return null;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }

}
