package com.kpi.railwaystation.db;

import lombok.Getter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static ConnectionPool instance = null;
    private ConnectionPool(){}
    public static ConnectionPool getInstance(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }

    @Getter
    private static volatile DataSource dataSource;

    public static DataSource getDataSource(){
        if (dataSource == null) {
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                    InitialContext context = null;
                    try {
                        context = new InitialContext();
                        dataSource = (DataSource) context.lookup("java:comp/env/jdbc/railwayStation");
                    } catch (NamingException e) {
                        e.printStackTrace();
                        dataSource = null;
                    }

                }
            }
        }
        return dataSource;
    }

    public Connection getConnection(){
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/railwayStation");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException  e) {
            e.printStackTrace();
        }
        return connection;
    }
}
