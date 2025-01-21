package com.personnal_project_uberApp.ride_service.services.impl;

import com.personnal_project_uberApp.ride_service.dto.DriverDto;
import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.entities.RideRequest;
import com.personnal_project_uberApp.ride_service.entities.enums.RideRequestStatus;
import com.personnal_project_uberApp.ride_service.entities.enums.RideStatus;
import com.personnal_project_uberApp.ride_service.repository.RideRequestRepository;
import com.personnal_project_uberApp.ride_service.services.RideService;
import com.personnal_project_uberApp.ride_service.strategies.DriverMatchingStrategy;
import com.personnal_project_uberApp.ride_service.strategies.RideFareCalculationStrategy;
import com.personnal_project_uberApp.ride_service.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;




    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        //Calculating Ride fare
        RideFareCalculationStrategy rideFareCalculationStrategy = rideStrategyManager.rideFareCalculationStrategy(rideRequest.getPickupLocation());
        double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        //Match with drivers
        DriverMatchingStrategy driverMatchingStrategy= rideStrategyManager.driverMatchingStrategy(3.0);
        List<Long> driverIdList = driverMatchingStrategy.findMatchingDrivers(rideRequestDto);
        //TODO send request to all the drivers through kafka

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
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
