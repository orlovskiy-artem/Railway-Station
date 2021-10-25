package com.kpi.railwaystation.controller.commands;

import com.kpi.railwaystation.controller.WebPages;
import com.kpi.railwaystation.dto.RouteDto;
import com.kpi.railwaystation.model.BasicTrainRoute;
import com.kpi.railwaystation.services.RouteService;
import com.kpi.railwaystation.utils.ServiceLocator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class AddRouteCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddRouteCommand.class);
    RouteService routeService = ServiceLocator.getRouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("-----executing add-routes command-----");
        if (request.getParameter("departure-datetime")!=null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
            LocalDateTime departureDatetime = LocalDateTime.parse(
                    request.getParameter("departure-datetime"),formatter);
            LocalDateTime arrivalDatetime = LocalDateTime.parse(
                    request.getParameter("arrival-datetime"),formatter);
            RouteDto routeDto = RouteDto.builder()
                    .departurePlatformId(Integer.valueOf(request.getParameter("departure-platform")))
                    .arrivalPlatformId(Integer.valueOf(request.getParameter("arrival-platform")))
                    .trainId(Integer.valueOf(request.getParameter("train")))
                    .departureDateTime(departureDatetime)
                    .arrivalDateTime(arrivalDatetime)
                    .build();
            routeService.createRoute(routeDto);
            return WebPages.MENU_PAGE;
        }
        return WebPages.GET_ADD_ROUTE_PAGE;
    }
}
