package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.postgresql.util.PGmoney;

import java.math.BigDecimal;

@Data
@Builder
@NonNull
public class Ticket {
    private Integer id;
    private Integer userId;
    private PGmoney price;
    private BasicTrainRoute basicTrainRoute;
}
