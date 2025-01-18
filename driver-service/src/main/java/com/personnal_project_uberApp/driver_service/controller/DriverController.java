package com.personnal_project_uberApp.driver_service.controller;


import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import com.personnal_project_uberApp.driver_service.services.DriverService;
import org.locationtech.jts.geom.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    private DriverService driverService;

    @GetMapping("/get-matching-ten-nearest-drivers")
    List<DriverDto> getTenNearestDrivers(Point pickUpLocation){
        return driverService.findTenNearestDrivers(pickUpLocation);
    }

}
