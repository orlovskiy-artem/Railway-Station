package com.kpi.railwaystation.controller.commands;

import com.kpi.railwaystation.controller.WebPages;
import com.kpi.railwaystation.exceptions.NoSeatsAvailableException;
import com.kpi.railwaystation.model.Seat;
import com.kpi.railwaystation.services.RouteService;
import com.kpi.railwaystation.utils.ServiceLocator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChooseSeatCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SearchRouteCommand.class);
    RouteService routeService = ServiceLocator.getRouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("-----executing choose-routes command-----");
        Integer routeId = Integer.valueOf(request.getParameter("route"));
        request.setAttribute("numberOfSeats",0);
        try{
            List<Seat> seats = routeService.findSeats(routeId);
            if(seats!=null){
                request.setAttribute("seats",seats);
                request.setAttribute("numberOfSeats",seats.size());
                request.setAttribute("numberOfSeatsHalved",seats.size()/2);
            }
            return WebPages.CHOOSE_SEAT_PAGE;
        } catch (NoSeatsAvailableException e) {
            return WebPages.NO_SEATS_AVAILABLE_PAGE;
        }
    }
}
