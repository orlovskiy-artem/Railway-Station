package com.kpi.railwaystation.DAO.impl.postgres;

import com.kpi.railwaystation.DAO.CustomerDAO;
import com.kpi.railwaystation.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresCustomerDAO implements CustomerDAO {
    private Connection connection;

    public PostgresCustomerDAO(Connection connection){
        this.connection = connection;
    }
    @Override
    public Customer createCustomer() {
        return null;
    }

    @Override
    public Customer readCustomer() {
        return null;
    }

    @Override
    public Customer updateCustomer() {
        return null;
    }

    @Override
    public Customer deleteCustomer() {
        return null;
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
