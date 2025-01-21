package com.personnal_project_uberApp.ride_service.strategies.impl;

import com.personnal_project_uberApp.ride_service.entities.RideRequest;
import com.personnal_project_uberApp.ride_service.services.DistanceService;
import com.personnal_project_uberApp.ride_service.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance=distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER*1.25;
    }
}
