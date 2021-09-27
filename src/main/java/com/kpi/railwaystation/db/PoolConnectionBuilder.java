package com.kpi.railwaystation.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.SQLException;
import java.sql.ShardingKey;

public class PoolConnectionBuilder  implements ConnectionBuilder {
    private DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(PoolConnectionBuilder.class);

    public PoolConnectionBuilder(){
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/railwayStation");
        } catch (NamingException e) {
            e.printStackTrace();
            logger.error("",e);
        }
    }

    @Override
    public ConnectionBuilder user(String username) {
        return null;
    }

    @Override
    public ConnectionBuilder password(String password) {
        return null;
    }

    @Override
    public ConnectionBuilder shardingKey(ShardingKey shardingKey) {
        return null;
    }

    @Override
    public ConnectionBuilder superShardingKey(ShardingKey superShardingKey) {
        return null;
    }

    @Override
    public Connection build() throws SQLException {
        return dataSource.getConnection("postgres","postgres");
    }
}
