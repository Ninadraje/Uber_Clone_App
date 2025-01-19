package com.personnal_project_uberApp.ride_service.clients;


import com.personnal_project_uberApp.ride_service.dto.DriverDto;
import com.personnal_project_uberApp.ride_service.dto.PointDto;
import org.locationtech.jts.geom.Point;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



@FeignClient(name="driver-service",path = "/driver")
public interface DriverClient {

    @GetMapping("/get-matching-ten-nearest-drivers")
    List<Long> getTenNearestDrivers(@RequestBody PointDto pickUpLocation);

    @GetMapping("/get-matching-ten-highest-rated-drivers")
    List<Long> findTenNearbyTopRatedDrivers(@RequestBody PointDto pickupLocation);
}