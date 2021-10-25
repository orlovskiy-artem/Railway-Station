package com.kpi.railwaystation.dao;

import com.kpi.railwaystation.model.*;
import org.postgresql.util.PGmoney;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConvertUtils {
    public static Platform extractDeparturePlatform(ResultSet resultSet) throws SQLException {
        return Platform.builder()
                .id(resultSet.getInt("departure_platform_id"))
                .city(resultSet.getString("departure_city"))
                .name(resultSet.getString("departure_platform_name"))
                .build();

    }

    public static Ticket extractTicket(ResultSet resultSet) throws SQLException {
        return Ticket.builder()
                .id(resultSet.getInt("ticket_id"))
                .userId(resultSet.getInt("user_id"))
                .price(resultSet.getObject("ticket_price", PGmoney.class))
                .basicTrainRoute(extractRoute(resultSet))
                .build();
    }

    public static Platform extractArrivalPlatform(ResultSet resultSet) throws SQLException {
        return Platform.builder()
                .id(resultSet.getInt("arrival_platform_id"))
                .city(resultSet.getString("arrival_city"))
                .name(resultSet.getString("arrival_platform_name"))
                .build();
    }

    public static BasicTrainRoute extractRoute(ResultSet resultSet) throws SQLException {
        return BasicTrainRoute.builder()
                .id(resultSet.getInt("route_id"))
                .departureDateTime(resultSet.getTimestamp("route_departure_datetime").toLocalDateTime())
                .arrivalDateTime(resultSet.getTimestamp("route_arrival_datetime").toLocalDateTime())
                .train(extractTrain(resultSet))
                .arrivalPlatform(extractArrivalPlatform(resultSet))
                .departurePlatform(extractDeparturePlatform(resultSet))
                .build();
    }
    public static Train extractTrain(ResultSet resultSet) throws SQLException {

        return Train.builder()
                .id(resultSet.getInt("train_id"))
                .name(resultSet.getString("train_name"))
                .type(resultSet.getString("train_type"))
                .build();
    }

    public static Seat extractSeat(ResultSet resultSet) throws SQLException {
        return Seat.builder()
                .id(resultSet.getInt("seat_id"))
                .type(resultSet.getString("seat_type"))
                .trainId(resultSet.getInt("train_id"))
                .build();
    }
}
