package com.kpi.railwaystation.Factory;

import com.kpi.railwaystation.DAO.*;
import com.kpi.railwaystation.model.Order;

import java.io.IOException;
import java.sql.SQLException;

public abstract class DAOFactory {
    public static final int POSTGRES = 1;

    public abstract CustomerDAO getCustomerDAO() throws SQLException, IOException;
    public abstract OrderDAO getOrderDAO() throws SQLException, IOException;
    public abstract PlatformDAO getPlatformDAO() throws SQLException, IOException;
    public abstract SeatDAO getSeatDAO() throws SQLException, IOException;
    public abstract TrainDAO getTrainDAO() throws SQLException, IOException;
    public static DAOFactory getDAOFactory(int factoryDB) {
        switch (factoryDB) {
            case POSTGRES:
                return new PostgreSQLFactory();
            default:
                return null;
        }

    }


}