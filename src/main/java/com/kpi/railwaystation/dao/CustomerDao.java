package com.kpi.railwaystation.dao;

import java.sql.SQLException;
import java.util.HashMap;

public interface CustomerDao {
    void createCustomer(String firstName, String lastName,
                        String email, String password, Integer roleId) throws SQLException;

    void readCustomerById(int customerId) throws SQLException;

    void updateCustomer(HashMap<String, Object> columnsNames2values, String identifier) throws SQLException;

    void deleteCustomerById(Integer id) throws SQLException;
}

