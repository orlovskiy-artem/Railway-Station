package com.kpi.railwaystation.sqlBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.sqlBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;

public class CartSqlStatementBuilder implements SqlStatementBuilder {
    @Override
    public String getCreateStatement() {
        return "INSERT INTO cart (name, type, train_id)" +
                "VALUES (?, ?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM cart WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String, Object> columnName2value,
                                     String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(String key : columnName2value.keySet()){
            updateValue.append(key).append("=").append("(?)").append("\n");
        }
        return "UPDATE cart SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM cart WHERE " + valueIdentifier + "=(?)";
    }
}