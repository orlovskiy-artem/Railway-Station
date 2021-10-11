package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.Train;

public interface TrainDao {
    public Train createTrain();
    public Train readTrain();
    public Train updateTrain();
    public Train deleteTrain();
}
