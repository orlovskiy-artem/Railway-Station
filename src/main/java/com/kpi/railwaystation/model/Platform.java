package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@NonNull
public class Platform {
    private Integer id;
    private String city;
    private String name;
}
