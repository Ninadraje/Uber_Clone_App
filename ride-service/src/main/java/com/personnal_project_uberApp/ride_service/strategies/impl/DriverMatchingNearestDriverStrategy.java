package com.personnal_project_uberApp.ride_service.strategies.impl;

import com.personnal_project_uberApp.ride_service.clients.DriverClient;
import com.personnal_project_uberApp.ride_service.dto.DriverDto;
import com.personnal_project_uberApp.ride_service.entities.RideRequest;
import com.personnal_project_uberApp.ride_service.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {


    private final DriverClient driverClient;

    public DriverMatchingNearestDriverStrategy(DriverClient driverClient) {
        this.driverClient = driverClient;
    }

    @Override
    public List<DriverDto> findMatchingDrivers(RideRequest rideRequest) {
        // call the Driver microservice from open feign to get the the required list of drivers.
        return driverClient.getTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
