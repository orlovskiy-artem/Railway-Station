package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Seat;

import java.sql.SQLException;
import java.util.List;

public interface SeatDao {
    public void createSeat();
    public Seat readSeat();
    public void updateSeat();
    public void deleteSeat();

    public List<Seat> getSeatsOfTrain(Integer trainId);
}
