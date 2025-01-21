package com.personnal_project_uberApp.ride_service.strategies.impl;

import com.personnal_project_uberApp.ride_service.clients.DriverClient;
import com.personnal_project_uberApp.ride_service.dto.DriverDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.entities.RideRequest;
import com.personnal_project_uberApp.ride_service.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    private final DriverClient driverClient;

    @Override
    public List<Long> findMatchingDrivers(RideRequestDto rideRequest) {
        // call the Driver microservice from open feign to get the the required list of drivers.
        return driverClient.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
