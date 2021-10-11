package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Seat;

import java.sql.SQLException;

public interface SeatDao {
    public Seat createSeat();
    public Seat readSeat();
    public Seat updateSeat();
    public Seat deleteSeat();
    public void closeConnection() throws SQLException;
}
