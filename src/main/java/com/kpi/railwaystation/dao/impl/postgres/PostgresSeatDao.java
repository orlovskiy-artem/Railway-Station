package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.SeatDao;
import com.kpi.railwaystation.model.Seat;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresSeatDao implements SeatDao {
    private Connection connection;

    public PostgresSeatDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public Seat createSeat() {
        return null;
    }

    @Override
    public Seat readSeat() {
        return null;
    }

    @Override
    public Seat updateSeat() {
        return null;
    }

    @Override
    public Seat deleteSeat() {
        return null;
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
