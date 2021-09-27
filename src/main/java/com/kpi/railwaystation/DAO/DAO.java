package com.kpi.railwaystation.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAO {
    public void closeConnection() throws SQLException;
}
