package com.personnal_project_uberApp.ride_service.services;


import com.personnal_project_uberApp.ride_service.dto.PointDto;
import org.locationtech.jts.geom.Point;


public interface WeatherService {
    String weatherCondition(Point src);
}
