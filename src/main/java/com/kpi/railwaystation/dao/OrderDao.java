package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Order;

import java.sql.SQLException;

public interface OrderDao {
    public Order createOrder() throws SQLException;
    public Order readOrder()  throws SQLException;
    public Order updateOrder() throws SQLException;
    public Order deleteOrder() throws SQLException;
}
