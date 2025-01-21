package com.personnal_project_uberApp.driver_service.controller;


import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import com.personnal_project_uberApp.driver_service.dto.PointDto;
import com.personnal_project_uberApp.driver_service.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/get-matching-ten-nearest-drivers")
    List<Long> getTenNearestDrivers(@RequestBody PointDto pickUpLocation){
        return driverService.findTenNearestDrivers(pickUpLocation);
    }

    @GetMapping("/get-matching-ten-highest-rated-drivers")
    List<Long> findTenNearbyTopRatedDrivers(@RequestBody Point pickupLocation){
        return driverService.findTenNearbyTopRatedDrivers(pickupLocation);
    }

}
