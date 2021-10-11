package com.kpi.railwaystation.factory;

import com.kpi.railwaystation.dao.*;

import java.io.IOException;
import java.sql.SQLException;

public abstract class DaoFactory {
    public static final int POSTGRES = 1;

    public abstract CustomerDao getCustomerDao() throws SQLException, IOException;
    public abstract OrderDao getOrderDao() throws SQLException, IOException;
    public abstract PlatformDao getPlatformDao() throws SQLException, IOException;
    public abstract SeatDao getSeatDao() throws SQLException, IOException;
    public abstract TrainDao getTrainDao() throws SQLException, IOException;
    public static DaoFactory getDAOFactory(int factoryDB) {
        switch (factoryDB) {
            case POSTGRES:
                return new PostgreSQLFactory();
            default:
                return null;
        }

    }


}