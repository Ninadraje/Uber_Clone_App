package com.personnal_project_uberApp.ride_service.services;

import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.dto.StartRideDto;
import com.personnal_project_uberApp.ride_service.entities.Ride;
import com.personnal_project_uberApp.ride_service.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RideService {

    //Ride request from the rider
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto getRideById(Long rideId);

    RideDto acceptRideRequest(Long rideRequestId);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    List<RideDto> getAllRidesOfRider(Long riderId);

    List<RideDto> getAllRidesOfDriver(Long driverId);

    RideDto startRide(Long rideId, StartRideDto startRideDto);
}
