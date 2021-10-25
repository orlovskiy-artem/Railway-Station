package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Ticket;

import java.sql.SQLException;

public interface OrderDao {
    public Ticket createOrder() throws SQLException;
    public Ticket readOrder()  throws SQLException;
    public Ticket updateOrder() throws SQLException;
    public Ticket deleteOrder() throws SQLException;
}
