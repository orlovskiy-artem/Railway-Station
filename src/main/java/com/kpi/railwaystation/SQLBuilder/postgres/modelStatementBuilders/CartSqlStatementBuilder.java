package com.kpi.railwaystation.SQLBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.SQLBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;
import java.util.Map;

public class CartSqlStatementBuilder implements SqlStatementBuilder {
    @Override
    public String getCreateStatement() {
        return "INSERT INTO cart (id, name, type, train_id)" +
                "VALUES (?, ?, ?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM cart WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String,String> columnName2value,
                                     String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(Map.Entry<String,String> entry : columnName2value.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            updateValue.append(key).append(" = ").append(value).append("\n");
        }
        return "UPDATE cart SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM cart WHERE " + valueIdentifier + "=(?)";
    }
}