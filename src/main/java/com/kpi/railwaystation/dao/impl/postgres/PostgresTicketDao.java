package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.OrderDao;
import com.kpi.railwaystation.model.Ticket;

import java.sql.Connection;

public class PostgresTicketDao implements OrderDao {
    private Connection connection;

    public PostgresTicketDao(java.sql.Connection connection){
        this.connection = connection;
    }

    @Override
    public Ticket createOrder() {
        return null;
    }

    @Override
    public Ticket readOrder() {
        return null;
    }

    @Override
    public Ticket updateOrder() {
        return null;
    }

    @Override
    public Ticket deleteOrder() {
        return null;
    }
}
