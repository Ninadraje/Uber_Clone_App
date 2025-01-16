package com.personnal_project_uberApp.rider_service.services;

import com.personnal_project_uberApp.rider_service.dto.RiderDto;

public interface RiderService {
//    RideRequestDto requestRide(RideRequestDto rideRequestDto);
//
//
//
//    DriverDto rateDriver(Long rideId, Integer rating);
//
//    List<RideDto> getAllMyRides();

    String rateARider(Long riderId);

    RiderDto getMyProfile();

    RiderDto updateProfile();

}
