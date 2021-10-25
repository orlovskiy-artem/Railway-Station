package com.kpi.railwaystation.dao.impl.postgres;

import com.kpi.railwaystation.dao.BasicTrainRouteDao;
import com.kpi.railwaystation.dao.ConvertUtils;
import com.kpi.railwaystation.dto.RouteDto;
import com.kpi.railwaystation.model.BasicTrainRoute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class PostgresBasicTrainRouteDao implements com.kpi.railwaystation.dao.BasicTrainRouteDao {
    private static final Logger LOGGER = Logger.getLogger(BasicTrainRouteDao.class.getName());
    private final Connection connection;

    public PostgresBasicTrainRouteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BasicTrainRoute> findByPath(String departureCity, String arrivalCity) {
        String query = "SELECT " +
                "r.id as route_id, " +
                "r.departure_datetime as route_departure_datetime, " +
                "r.arrival_datetime as route_arrival_datetime, " +
                "r.departure_platform_id as departure_platform_id, " +
                "r.arrival_platform_id as arrival_platform_id, " +
                "t.id as train_id, " +
                "t.type as train_type, " +
                "t.name as train_name, " +
                "p.city as departure_city, " +
                "p2.city as arrival_city, " +
                "p.name as departure_platform_name, " +
                "p2.name as arrival_platform_name" +
                " FROM route r" +
                "  INNER JOIN  platform p ON p.id = r.departure_platform_id" +
                "  INNER JOIN  platform p2 ON p2.id = r.arrival_platform_id" +
                "  INNER JOIN  train t ON t.id = r.train_id" +
                " WHERE p.city=? AND p2.city=?;";
        List<BasicTrainRoute> routes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Integer parameterIndex = 0;
            preparedStatement.setString(++parameterIndex,departureCity);
            preparedStatement.setString(++parameterIndex,arrivalCity);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BasicTrainRoute route = ConvertUtils.extractRoute(resultSet);
                routes.add(route);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        };
        return routes;
    }

    @Override
    public void create(RouteDto routeDto) {
        String query = "INSERT INTO route (" +
                "departure_platform_id, " +
                "arrival_platform_id," +
                " train_id," +
                " departure_datetime," +
                " arrival_datetime) VALUES ((?),(?),(?),(?),(?))";
        try {
            Integer parameterIndex = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(++parameterIndex, routeDto.getDeparturePlatformId());
            preparedStatement.setInt(++parameterIndex, routeDto.getArrivalPlatformId());
            preparedStatement.setInt(++parameterIndex, routeDto.getTrainId());
            preparedStatement.setTimestamp(++parameterIndex, Timestamp.valueOf(routeDto.getDepartureDateTime()));
            preparedStatement.setTimestamp(++parameterIndex, Timestamp.valueOf(routeDto.getArrivalDateTime()));
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        };
    }

    @Override
    public List<BasicTrainRoute> read() {
        String query =
                "SELECT " +
                        "r.id as route_id, " +
                        "r.departure_datetime as route_departure_datetime, " +
                        "r.arrival_datetime as route_arrival_datetime, " +
                        "r.departure_platform_id as departure_platform_id, " +
                        "r.arrival_platform_id as arrival_platform_id, " +
                        "t.id as train_id, " +
                        "t.type as train_type, " +
                        "t.name as train_name, " +
                        "p.city as departure_city, " +
                        "p2.city as arrival_city, " +
                        "p.name as departure_platform_name, " +
                        "p2.name as arrival_platform_name" +
                        " FROM route r \n" +
                        "INNER JOIN train t on r.train_id = t.id\n" +
                        "INNER JOIN platform p on p.id = r.departure_platform_id\n" +
                        "INNER JOIN platform p2 on p2.id = r.arrival_platform_id;";
        List<BasicTrainRoute> routes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                BasicTrainRoute route = ConvertUtils.extractRoute(resultSet);
                routes.add(route);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        };
        return routes;
    }

    @Override
    public void update(BasicTrainRoute updateBasicTrainRoute) {

    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM route r WHERE r.id=(?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        };
    }

    @Override
    public Optional<BasicTrainRoute> findById(Integer routeId) {
        String query = "SELECT " +
                "r.id as route_id, " +
                "r.departure_datetime as route_departure_datetime, " +
                "r.arrival_datetime as route_arrival_datetime, " +
                "r.departure_platform_id as departure_platform_id, " +
                "r.arrival_platform_id as arrival_platform_id, " +
                "t.id as train_id, " +
                "t.type as train_type, " +
                "t.name as train_name, " +
                "p.city as departure_city, " +
                "p2.city as arrival_city, " +
                "p.name as departure_platform_name, " +
                "p2.name as arrival_platform_name" +
                " FROM route r " +
                "INNER JOIN train t on r.train_id = t.id " +
                "INNER JOIN platform p on p.id = r.departure_platform_id " +
                "INNER JOIN platform p2 on p2.id = r.arrival_platform_id " +
                "WHERE r.id=?;";
        BasicTrainRoute route = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Integer parameterIndex = 0;
            preparedStatement.setInt(++parameterIndex,routeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                route = ConvertUtils.extractRoute(resultSet);
                return Optional.of(route);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        };
        return Optional.empty();
    }
}
