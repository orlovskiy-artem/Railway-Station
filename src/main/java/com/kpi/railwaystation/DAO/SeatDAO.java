package com.kpi.railwaystation.DAO;

import com.kpi.railwaystation.model.Seat;

import java.sql.SQLException;

public interface SeatDAO {
    public Seat createSeat();
    public Seat readSeat();
    public Seat updateSeat();
    public Seat deleteSeat();
    public void closeConnection() throws SQLException;
}
