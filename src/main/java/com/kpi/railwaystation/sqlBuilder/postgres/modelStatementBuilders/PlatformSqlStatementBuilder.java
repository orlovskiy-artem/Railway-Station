package com.kpi.railwaystation.sqlBuilder.postgres.modelStatementBuilders;

import com.kpi.railwaystation.sqlBuilder.postgres.SqlStatementBuilder;

import java.util.HashMap;

public class PlatformSqlStatementBuilder implements SqlStatementBuilder {
    @Override
    public String getCreateStatement() {
        return "INSERT INTO platform (name, city)" +
                "VALUES (?, ?)";
    }

    @Override
    public String getReadStatement(String valueIdentifier) {
        return "SELECT * FROM platform WHERE " + valueIdentifier + "=(?)";
    }

    @Override
    public String getUpdateStatement(HashMap<String, Object> columnName2value,
                                     String identifier) {
        StringBuilder updateValue = new StringBuilder();
        for(String key : columnName2value.keySet()){
            updateValue.append(key).append("=").append("(?)").append("\n");
        }
        return "UPDATE platform SET " + updateValue + "WHERE id=" + identifier;
    }

    @Override
    public String getDeleteStatement(String valueIdentifier) {
        return "DELETE FROM platform WHERE " + valueIdentifier + "=(?)";
    }
}
