package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.TrainDao;
import com.kpi.railwaystation.model.Train;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresTrainDao implements TrainDao {
    private Connection connection;


    public PostgresTrainDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public Train createTrain() {
        return null;
    }

    @Override
    public Train readTrain() {
        return null;
    }

    @Override
    public Train updateTrain() {
        return null;
    }

    @Override
    public Train deleteTrain() {
        return null;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
