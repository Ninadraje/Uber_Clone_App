package com.personnal_project_uberApp.ride_service.strategies;

import com.personnal_project_uberApp.ride_service.dto.DriverDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

   List<DriverDto> findMatchingDrivers(RideRequest rideRequest);

}
