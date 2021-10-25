package com.kpi.railwaystation.services.impl;

import com.kpi.railwaystation.dao.BasicTrainRouteDao;
import com.kpi.railwaystation.dao.SeatDao;
import com.kpi.railwaystation.dao.TrainDao;
import com.kpi.railwaystation.dao.UserDao;
import com.kpi.railwaystation.services.RouteService;
import com.kpi.railwaystation.services.TicketService;

import java.util.logging.Logger;

public class TicketServiceImpl implements TicketService {
    private static final Logger LOGGER = Logger.getLogger(TicketService.class.getName());
    private final UserDao userDao;
    private final BasicTrainRouteDao routeDao;
    private final TrainDao trainDao;
    private final SeatDao seatDao;

    public TicketServiceImpl(UserDao userDao,
                             BasicTrainRouteDao routeDao,
                             TrainDao trainDao,
                             SeatDao seatDao) {
        this.userDao = userDao;
        this.routeDao = routeDao;
        this.trainDao = trainDao;
        this.seatDao = seatDao;
    }
}
