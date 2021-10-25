package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.UserDao;
import com.kpi.railwaystation.sqlBuilder.postgres.modelStatementBuilders.UserSqlStatementBuilder;
import com.kpi.railwaystation.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PostgresUserDao implements UserDao {

    private Connection connection;
    private static final UserSqlStatementBuilder USER_SQL_STATEMENT_BUILDER = new UserSqlStatementBuilder();
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgresUserDao.class);

    public PostgresUserDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public void createUser(String firstName, String lastName,
                           String email, String password, Integer roleId) throws SQLException {
        String createStatement = USER_SQL_STATEMENT_BUILDER.getCreateStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(createStatement);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setInt(5, roleId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public User getUserFromResultSet(ResultSet rs) throws SQLException{
        User user = null;
        while (rs.next()) {
            user = User.builder()
                    .id(rs.getInt("id"))
                    .firstName(rs.getString("first_name"))
                    .lastName(rs.getString("last_name"))
                    .email(rs.getString("email"))
                    .password(rs.getString("password"))
                    .roleId(rs.getInt("role_id"))
                    .build();
        }
        rs.close();
        return user;
    }

    @Override
    public User readUserById(Integer userId) throws SQLException {
        String createStatement = USER_SQL_STATEMENT_BUILDER.getReadStatement("id");
        PreparedStatement preparedStatement = connection.prepareStatement(createStatement);
        preparedStatement.setInt(1, userId);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        User user = getUserFromResultSet(rs);
        preparedStatement.close();
        return user;
    }


    @Override
    public User readUserByEmail(String email) throws SQLException {
        String createStatementString = USER_SQL_STATEMENT_BUILDER.getReadStatement("email");
        PreparedStatement preparedStatement = connection.prepareStatement(createStatementString);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        User user = getUserFromResultSet(rs);
        preparedStatement.close();
        return user;
    }

    @Override
    public void updateUser(HashMap<String, Object> columnsNames2values, String identifier) throws SQLException {
        String updateStatement = USER_SQL_STATEMENT_BUILDER.getUpdateStatement(columnsNames2values,identifier);
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
        Integer index = 0;
        for(Map.Entry<String,Object> colName2value: columnsNames2values.entrySet()){
            String key = colName2value.getKey();
            Object value = colName2value.getValue();
            if(value instanceof String ) {
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
    public void deleteUserById(Integer id) throws SQLException {
        String deleteStatement = USER_SQL_STATEMENT_BUILDER.getDeleteStatement("id");
        PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
