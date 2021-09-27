package com.kpi.railwaystation.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Train implements Serializable {
    private Integer id;
    private String name;
    private String type;
}
