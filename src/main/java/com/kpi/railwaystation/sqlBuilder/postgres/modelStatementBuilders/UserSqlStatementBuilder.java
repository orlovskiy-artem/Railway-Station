package com.kpi.railwaystation.sqlBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.sqlBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;

public class UserSqlStatementBuilder implements SqlStatementBuilder {

    @Override
    public String getCreateStatement() {
        return "INSERT INTO customer (first_name, last_name," +
                "email, password, role_id)" +
                "VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM customer WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String, Object> columnName2value, String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(String key : columnName2value.keySet()){
            updateValue.append(key).append("=").append("(?)").append("\n");
        }
        return "UPDATE customer SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM customer WHERE " + valueIdentifier + "=(?)";
    }
}
