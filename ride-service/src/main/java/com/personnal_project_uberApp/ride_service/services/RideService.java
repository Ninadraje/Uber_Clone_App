package com.personnal_project_uberApp.ride_service.services;

import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RideService {

    //Ride request from the rider
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    RideDto createNewRide(RideRequestDto rideRequestDto, Long driverId);

    RideDto updateRideStatus(Long rideId, RideStatus rideStatus);

    List<RideDto> getAllRidesOfRider(Long riderId);

    List<RideDto> getAllRidesOfDriver(Long driverId);
}
