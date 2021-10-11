package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Order;

public interface OrderDao {
    public Order createOrder();
    public Order readOrder();
    public Order updateOrder();
    public Order deleteOrder();
}
