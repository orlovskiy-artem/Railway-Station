package com.kpi.railwaystation.services;

import com.kpi.railwaystation.dto.RouteDto;
import com.kpi.railwaystation.exceptions.NoSeatsAvailableException;
import com.kpi.railwaystation.model.BasicTrainRoute;
import com.kpi.railwaystation.model.Seat;

import java.util.List;

public interface RouteService {
    List<BasicTrainRoute> findByPath(String departureCity, String arrivalCity);
    List<Seat> findSeats(Integer routeId) throws NoSeatsAvailableException;
    void createRoute(RouteDto routeDto);
}
