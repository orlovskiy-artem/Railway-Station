package com.kpi.railwaystation.controller.commands;

import com.kpi.railwaystation.controller.WebPages;
import com.kpi.railwaystation.model.BasicTrainRoute;
import com.kpi.railwaystation.services.RouteService;
import com.kpi.railwaystation.utils.ServiceLocator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchRouteCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SearchRouteCommand.class);
    RouteService routeService = ServiceLocator.getRouteService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("-----executing search-routes command-----");
        String departureCity = request.getParameter("departure-city");
        String arrivalCity = request.getParameter("arrival-city");
        if(departureCity != null && arrivalCity!=null){
            List<BasicTrainRoute> routes = routeService.findByPath(departureCity, arrivalCity);
            request.setAttribute("routes",routes);
            return "jsp/routes-list.jsp";
//            return "redirect:/api?command=search-routes";
        }
        return WebPages.SEARCH_ROUTES_PAGE;
    }
}
