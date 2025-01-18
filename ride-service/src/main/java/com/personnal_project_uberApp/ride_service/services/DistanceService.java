package com.personnal_project_uberApp.ride_service.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    double calculateDistance(Point src, Point dest);
}
