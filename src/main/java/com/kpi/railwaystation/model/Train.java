package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Builder
@NonNull
public class Train implements Serializable {
    private Integer id;
    private String name;
    private String type;
}
