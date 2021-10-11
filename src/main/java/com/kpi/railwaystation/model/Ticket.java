package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NonNull
public class Ticket {
    private BigDecimal price;
    List<BasicTrainRoute> routes;
}
