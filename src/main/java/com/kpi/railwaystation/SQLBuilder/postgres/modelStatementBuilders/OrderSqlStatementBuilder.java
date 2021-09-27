package com.kpi.railwaystation.SQLBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.SQLBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;
import java.util.Map;

public class OrderSqlStatementBuilder implements SqlStatementBuilder {

    @Override
    public String getCreateStatement() {
        return "INSERT INTO `order` (id, customer_id, price)" +
                "VALUES (?, ?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM `order` WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String, String> columnName2value, String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(Map.Entry<String,String> entry : columnName2value.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            updateValue.append(key).append(" = ").append(value).append("\n");
        }
        return "UPDATE `order` SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM `order` WHERE " + valueIdentifier + "=(?)";
    }
}
