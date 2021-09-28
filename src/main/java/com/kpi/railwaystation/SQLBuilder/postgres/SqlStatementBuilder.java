package com.kpi.railwaystation.SQLBuilder.postgres;

import java.util.HashMap;

public interface SqlStatementBuilder {
    String getCreateStatement();
    String getReadStatement(String valueIdentifier);
    String getUpdateStatement(HashMap<String, Object> columnName2value, String identifier);
    String getDeleteStatement(String valueIdentifier);
}
