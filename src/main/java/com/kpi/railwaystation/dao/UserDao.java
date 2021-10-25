package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.User;

import java.sql.SQLException;
import java.util.HashMap;

public interface UserDao {
    void createUser(String firstName, String lastName,
                    String email, String password, Integer roleId) throws SQLException;

    User readUserById(Integer userId) throws SQLException;
    User readUserByEmail(String email) throws SQLException;
    void updateUser(HashMap<String, Object> columnsNames2values, String identifier) throws SQLException;
    void deleteUserById(Integer id) throws SQLException;
}

