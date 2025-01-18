package com.personnal_project_uberApp.ride_service.services.impl;

import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.entities.enums.RideStatus;
import com.personnal_project_uberApp.ride_service.services.RideService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {


    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
    }

    @Override
    public RideDto getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public RideDto createNewRide(RideRequestDto rideRequestDto, Long driverId) {
        return null;
    }

    @Override
    public RideDto updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public List<RideDto> getAllRidesOfRider(Long riderId) {
        return List.of();
    }

    @Override
    public List<RideDto> getAllRidesOfDriver(Long driverId) {
        return List.of();
    }
}
