package com.kpi.railwaystation.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
public class RouteDto {
    private Integer id;
    private Integer departurePlatformId;
    private Integer arrivalPlatformId;
    private Integer trainId;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

}
