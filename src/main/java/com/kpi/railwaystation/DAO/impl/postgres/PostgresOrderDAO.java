package com.kpi.railwaystation.DAO.impl.postgres;

import com.kpi.railwaystation.DAO.OrderDAO;
import com.kpi.railwaystation.model.Order;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresOrderDAO implements OrderDAO {
    private Connection connection;

    public PostgresOrderDAO(java.sql.Connection connection){
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
    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

}
