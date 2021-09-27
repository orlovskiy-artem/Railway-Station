package com.kpi.railwaystation.SQLBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.SQLBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;
import java.util.Map;

public class CustomerSqlStatementBuilder  implements SqlStatementBuilder {

    @Override
    public String getCreateStatement() {
        return "INSERT INTO customer (id, first_name, last_name," +
                "email, password, role_id)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM customer WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String, String> columnName2value, String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(Map.Entry<String,String> entry : columnName2value.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            updateValue.append(key).append(" = ").append(value).append("\n");
        }
        return "UPDATE customer SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM customer WHERE " + valueIdentifier + "=(?)";
    }
}
