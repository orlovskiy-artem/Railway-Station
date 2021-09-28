package com.kpi.railwaystation.SQLBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.SQLBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;

public class OrderSqlStatementBuilder implements SqlStatementBuilder {

    @Override
    public String getCreateStatement() {
        return "INSERT INTO `order` (customer_id, price)" +
                "VALUES (?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM `order` WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String, Object> columnName2value, String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(String key : columnName2value.keySet()){
            updateValue.append(key).append("=").append("(?)").append("\n");
        }
        return "UPDATE `order` SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM `order` WHERE " + valueIdentifier + "=(?)";
    }
}
