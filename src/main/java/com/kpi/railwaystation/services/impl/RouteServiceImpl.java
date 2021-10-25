package com.kpi.railwaystation.services.impl;

import com.kpi.railwaystation.dao.BasicTrainRouteDao;
import com.kpi.railwaystation.dao.SeatDao;
import com.kpi.railwaystation.dao.TrainDao;
import com.kpi.railwaystation.dto.RouteDto;
import com.kpi.railwaystation.exceptions.NoSeatsAvailableException;
import com.kpi.railwaystation.model.BasicTrainRoute;
import com.kpi.railwaystation.model.Seat;
import com.kpi.railwaystation.services.RouteService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class RouteServiceImpl implements RouteService {
    private static final Logger LOGGER = Logger.getLogger(RouteService.class.getName());
    private final BasicTrainRouteDao routeDao;
    private final SeatDao seatDao;
    public RouteServiceImpl(BasicTrainRouteDao routeDao,
                            SeatDao seatDao) {
        this.routeDao = routeDao;
        this.seatDao = seatDao;
    }
    public List<BasicTrainRoute> findByPath(String departureCity, String arrivalCity) {
        try{
            return routeDao.findByPath(departureCity, arrivalCity);
        } catch (SQLException e){
            LOGGER.severe(e.getMessage());
            return new ArrayList<BasicTrainRoute>();
        }
    }

    @Override
    public List<Seat> findSeats(Integer routeId) throws NoSeatsAvailableException {
        Optional<BasicTrainRoute> routeOpt = routeDao.findById(routeId);
        if(routeOpt.isPresent()){
            BasicTrainRoute route = routeOpt.get();
            Integer trainId = route.getTrain().getId();
            List<Seat> seats = seatDao.getSeatsOfTrain(trainId);
            return seats;
        } else {
            throw new NoSeatsAvailableException("No seats available!");
        }
    }

    @Override
    public void createRoute(RouteDto routeDto) {
        routeDao.create(routeDto);
    }
}
