package com.kpi.railwaystation.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@NonNull
public class BasicTrainRoute {
    private Platform departureStation;
    private Platform arrivalStation;
    private Train train;
    private Time departureTime;
    private Time arrivalTime;
    private Date departureDate;
    private Date arrivalDate;
}
