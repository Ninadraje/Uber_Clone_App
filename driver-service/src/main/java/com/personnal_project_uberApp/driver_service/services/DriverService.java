package com.personnal_project_uberApp.driver_service.services;

import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import org.locationtech.jts.geom.Point;

import java.util.List;

public interface DriverService {

    String rateADriver(Long riderId,int rating);

    DriverDto getAProfile();

    DriverDto updateProfile();

    List<DriverDto> findTenNearestDrivers(Point pickUpLocation);

}
