package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Seat;

import java.sql.SQLException;

public interface TicketDao {
    public Seat createTicket() throws SQLException;
    public Seat readTicket() throws SQLException;
    public Seat updateTicket() throws SQLException;
    public Seat deleteTicket() throws SQLException;
}
