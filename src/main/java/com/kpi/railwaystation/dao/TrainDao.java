package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Train;

import java.sql.SQLException;

public interface TrainDao {
    public Train createTrain() throws SQLException;
    public Train readTrain() throws SQLException;
    public Train updateTrain() throws SQLException;
    public Train deleteTrain() throws SQLException;
}
