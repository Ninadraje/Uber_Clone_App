package com.personnal_project_uberApp.ride_service.services;

import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.dto.StartRideDto;
import com.personnal_project_uberApp.ride_service.entities.Ride;
import com.personnal_project_uberApp.ride_service.entities.enums.RideStatus;

import java.util.List;

public interface RideService {

    //Ride request from the rider
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto getRideById(Long rideId);

    RideDto acceptRideRequest(Long rideRequestId);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    List<RideDto> getAllRidesOfRider();

    List<RideDto> getAllRidesOfDriver();

    RideDto startRide(Long rideId, StartRideDto startRideDto);

    RideDto endRide(Long rideId);

    RideDto cancelRideByRider(Long rideId);

    RideDto cancelRideByDriver(Long rideId);
}
