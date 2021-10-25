package com.kpi.railwaystation.services.impl;

import com.kpi.railwaystation.dao.UserDao;
import com.kpi.railwaystation.dao.impl.postgres.PostgresUserDao;
import com.kpi.railwaystation.dto.UserDto;
import com.kpi.railwaystation.factory.DaoFactory;
import com.kpi.railwaystation.factory.PostgreSQLFactory;
import com.kpi.railwaystation.services.UserService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserServiceImpl() throws SQLException, IOException {
        PostgreSQLFactory postgreSQLFactory = (PostgreSQLFactory) DaoFactory.getDAOFactory(1);
        Connection connection = postgreSQLFactory.createConnection();
        this.userDao = new PostgresUserDao(connection);
    }
    @Override
    public UserDto login(String email, String password) {

        return null;
    }

    @Override
    public void changePassword(String email, String newPassword) {

    }

    @Override
    public void save(UserDto userDto) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
