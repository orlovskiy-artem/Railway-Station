package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@NonNull
public class Order {
    private Integer id;
    private Integer customerId;
    private Integer price;
}
