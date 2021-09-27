package com.kpi.railwaystation.DAO;

import com.kpi.railwaystation.model.Order;

import java.sql.SQLException;

public interface OrderDAO extends DAO{
    public Order createOrder();
    public Order readOrder();
    public Order updateOrder();
    public Order deleteOrder();
}
