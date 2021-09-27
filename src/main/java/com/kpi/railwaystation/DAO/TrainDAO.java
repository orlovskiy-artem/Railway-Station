package com.kpi.railwaystation.DAO;

import com.kpi.railwaystation.model.Train;

public interface TrainDAO extends DAO{
    public Train createTrain();
    public Train readTrain();
    public Train updateTrain();
    public Train deleteTrain();
}
