package com.kpi.railwaystation.DAO.impl.postgres;

import com.kpi.railwaystation.DAO.SeatDAO;
import com.kpi.railwaystation.model.Seat;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresSeatDAO implements SeatDAO {
    private Connection connection;

    public PostgresSeatDAO(Connection connection){
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
