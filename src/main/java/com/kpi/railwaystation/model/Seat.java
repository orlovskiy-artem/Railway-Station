package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@NonNull
public class Seat {
    private Integer id;
    private String type;
    private Integer cartId;
}
