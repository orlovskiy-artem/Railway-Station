package com.kpi.railwaystation.DAO.impl.postgres;

import com.kpi.railwaystation.DAO.TrainDAO;
import com.kpi.railwaystation.model.Train;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresTrainDAO implements TrainDAO {
    private Connection connection;


    public PostgresTrainDAO(Connection connection){
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

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
