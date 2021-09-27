package com.kpi.railwaystation.DAO;

import com.kpi.railwaystation.model.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends DAO{
    public Customer createCustomer();
    public Customer readCustomer();
    public Customer updateCustomer();
    public Customer deleteCustomer();
}

