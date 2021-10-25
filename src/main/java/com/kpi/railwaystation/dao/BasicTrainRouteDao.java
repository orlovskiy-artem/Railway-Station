package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.dto.RouteDto;
import com.kpi.railwaystation.model.BasicTrainRoute;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BasicTrainRouteDao {
    List<BasicTrainRoute> findByPath(String departureCity, String arrivalCity) throws SQLException;
    void create(RouteDto routeDto);
    List<BasicTrainRoute> read();
    void update(BasicTrainRoute updateBasicTrainRoute);
    void delete(Integer id);

    Optional<BasicTrainRoute> findById(Integer routeId);
}
