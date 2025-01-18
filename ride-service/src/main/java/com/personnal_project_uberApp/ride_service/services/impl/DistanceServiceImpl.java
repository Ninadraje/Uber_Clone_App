package com.personnal_project_uberApp.ride_service.services.impl;

import com.personnal_project_uberApp.ride_service.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;


@Service
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
        //TODO calculate third party api OSRM to calaculate distance
        return 0;
    }
}
