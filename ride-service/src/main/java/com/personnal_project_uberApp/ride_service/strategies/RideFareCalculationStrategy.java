package com.personnal_project_uberApp.ride_service.strategies;

import com.personnal_project_uberApp.ride_service.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER= 10;

    double calculateFare(RideRequest rideRequest);
}
