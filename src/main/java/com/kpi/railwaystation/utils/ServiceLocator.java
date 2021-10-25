package com.kpi.railwaystation.utils;

import com.kpi.railwaystation.dao.BasicTrainRouteDao;
import com.kpi.railwaystation.dao.SeatDao;
import com.kpi.railwaystation.dao.TrainDao;
import com.kpi.railwaystation.dao.UserDao;
import com.kpi.railwaystation.dao.impl.postgres.PostgresBasicTrainRouteDao;
import com.kpi.railwaystation.dao.impl.postgres.PostgresSeatDao;
import com.kpi.railwaystation.dao.impl.postgres.PostgresTrainDao;
import com.kpi.railwaystation.dao.impl.postgres.PostgresUserDao;
import com.kpi.railwaystation.db.ConnectionPool;
import com.kpi.railwaystation.model.Seat;
import com.kpi.railwaystation.model.Train;
import com.kpi.railwaystation.model.User;
import com.kpi.railwaystation.services.RouteService;
import com.kpi.railwaystation.services.TicketService;
import com.kpi.railwaystation.services.impl.RouteServiceImpl;
import com.kpi.railwaystation.services.impl.TicketServiceImpl;

import javax.sql.DataSource;
import java.sql.SQLException;

public final class ServiceLocator {
    private static final RouteService routeService;
    private static final TicketService ticketService;
    static {
        DataSource dataSource = ConnectionPool.getInstance().getDataSource();
        BasicTrainRouteDao routeDao = null;
        SeatDao seatDao = null;
        TrainDao trainDao = null;
        UserDao userDao = null;
        try {
            routeDao = new PostgresBasicTrainRouteDao(dataSource.getConnection());
            seatDao = new PostgresSeatDao(dataSource.getConnection());
            trainDao = new PostgresTrainDao(dataSource.getConnection());
            userDao = new PostgresUserDao(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        routeService = new RouteServiceImpl(routeDao, seatDao);
        ticketService = new TicketServiceImpl(userDao, routeDao, trainDao, seatDao);
    }

    public static RouteService getRouteService() {
        return routeService;
    }
    public static TicketService getTicketService() {return ticketService;}
}
