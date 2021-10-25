package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.BasicTrainRouteDao;
import com.kpi.railwaystation.dao.ConvertUtils;
import com.kpi.railwaystation.dao.SeatDao;
import com.kpi.railwaystation.model.BasicTrainRoute;
import com.kpi.railwaystation.model.Seat;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class PostgresSeatDao implements SeatDao {
    private static final Logger LOGGER = Logger.getLogger(PostgresSeatDao.class.getName());
    private final Connection connection;

    public PostgresSeatDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createSeat() {}

    @Override
    public Seat readSeat() {
        return null;
    }

    @Override
    public void updateSeat() {}

    @Override
    public void deleteSeat() {}

    @Override
    public List<Seat> getSeatsOfTrain(Integer trainId) {
        String query = "SELECT s.id as seat_id," +
                "              s.type as seat_type," +
                "              t.id as train_id," +
                "              t.name as train_name," +
                "              t.type as train_type " +
                "FROM seat s " +
                "INNER JOIN train t ON t.id=s.train_id WHERE t.id=?;";
        List<Seat> seats = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Integer parameterIndex = 0;
            preparedStatement.setInt(++parameterIndex,trainId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Seat seat = ConvertUtils.extractSeat(resultSet);
                seats.add(seat);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        };
        return seats;
    }
}
