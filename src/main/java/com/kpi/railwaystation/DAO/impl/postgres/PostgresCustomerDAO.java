package com.kpi.railwaystation.DAO.impl.postgres;

import com.kpi.railwaystation.DAO.CustomerDAO;
import com.kpi.railwaystation.SQLBuilder.postgres.modelStatementBuilders.CustomerSqlStatementBuilder;
import com.kpi.railwaystation.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PostgresCustomerDAO implements CustomerDAO {

    private Connection connection;
    private static final CustomerSqlStatementBuilder customerSqlStatementBuilder = new CustomerSqlStatementBuilder();
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgresCustomerDAO.class);

    public PostgresCustomerDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void createCustomer(String firstName, String lastName,
                               String email, String password, Integer roleId) throws SQLException {
        System.out.println("here");
        String createStatement = customerSqlStatementBuilder.getCreateStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(createStatement);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setInt(5, roleId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void readCustomerById(int customerId) throws SQLException {
        String createStatement = customerSqlStatementBuilder.getReadStatement("id");
        PreparedStatement preparedStatement = connection.prepareStatement(createStatement);
        preparedStatement.setInt(1, customerId);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        Customer customer;
        while (rs.next()) {
            customer = Customer.builder()
                    .id(rs.getInt("id"))
                    .firstName(rs.getString("first_name"))
                    .lastName(rs.getString("last_name"))
                    .email(rs.getString("email"))
                    .password(rs.getString("password"))
                    .roleId(rs.getInt("role_id"))
                    .build();
        }
        rs.close();
        preparedStatement.close();
    }

    @Override
    public void updateCustomer(HashMap<String, Object> columnsNames2values, String identifier) throws SQLException {
        String updateStatement = customerSqlStatementBuilder.getUpdateStatement(columnsNames2values,identifier);
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
        Integer index = 0;
        for(Map.Entry<String,Object> colName2value: columnsNames2values.entrySet()){
            String key = colName2value.getKey();
            Object value = colName2value.getValue();
            if(value instanceof String) {
                preparedStatement.setString(index, (String) value);
            } else if (value instanceof Integer) {
                preparedStatement.setInt(index, (Integer) value);
            }
            index+=1;
        }
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteCustomerById(Integer id) throws SQLException {
        String deleteStatement = customerSqlStatementBuilder.getDeleteStatement("id");
        PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
