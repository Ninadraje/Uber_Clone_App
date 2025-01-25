package com.personnal_project_uberApp.ride_service.services.impl;

import com.personnal_project_uberApp.ride_service.dto.DriverDto;
import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.dto.StartRideDto;
import com.personnal_project_uberApp.ride_service.entities.Ride;
import com.personnal_project_uberApp.ride_service.entities.RideRequest;
import com.personnal_project_uberApp.ride_service.entities.enums.RideRequestStatus;
import com.personnal_project_uberApp.ride_service.entities.enums.RideStatus;
import com.personnal_project_uberApp.ride_service.exception.ResourceNotFoundException;
import com.personnal_project_uberApp.ride_service.repository.RideRepository;
import com.personnal_project_uberApp.ride_service.repository.RideRequestRepository;
import com.personnal_project_uberApp.ride_service.services.RideService;
import com.personnal_project_uberApp.ride_service.strategies.DriverMatchingStrategy;
import com.personnal_project_uberApp.ride_service.strategies.RideFareCalculationStrategy;
import com.personnal_project_uberApp.ride_service.strategies.RideStrategyManager;
import com.personnal_project_uberApp.ride_service.utils.OtpUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RideRepository rideRepository;


    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        //TODO get rider ID from the USER-CONTEXT holder and set it in the ride request , currently we are sending it in the request
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
    @Transactional
    public RideDto acceptRideRequest(Long rideRequestId) {

        RideRequest rideRequest=rideRequestRepository.findById(rideRequestId).orElseThrow(
                ()-> new ResourceNotFoundException("No Ride request found for this id "+rideRequestId)
        );

        //checking if Ride request is in Pending status or not
        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("Ride already accepted or cancelled by user");
        }

        //TODO get driverID from the User context holder , right now hard-coding this field
        //TODO after confirmation of the ride , update the availability of the driver
        Long currentDriverId=22L;

        Ride ride=createNewRide(rideRequest,currentDriverId);

        return modelMapper.map(ride, RideDto.class);
    }

    private Ride createNewRide(RideRequest rideRequest, Long currentDriverId) {

        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);

        Ride ride = modelMapper.map(rideRequest,Ride.class);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setDriverId(currentDriverId);
        ride.setOtp(String.valueOf(OtpUtils.generateOtp()));
        ride.setId(null);

        rideRepository.save(ride);
        rideRequestRepository.save(rideRequest);

        return ride;
    }

    @Override
    public RideDto startRide(Long rideId, StartRideDto startRideDto) {

        //TODO get driverID from the User context holder , right now hard-coding this field
        Long currentDriverId=22L;

        Ride ride = rideRepository.findById(rideId).orElseThrow(
                ()-> new ResourceNotFoundException("ride detail not found for id "+rideId));

        //checking the driver
        if(!ride.getDriverId().equals(currentDriverId)){
            throw new RuntimeException("Drivers are different for this ride");
        }

        //checking the ride status
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride is not confirmed or cancelled");
        }

        if(!ride.getOtp().equals(startRideDto.getOtp())){
            throw new RuntimeException("Otp is not valid");
        }

        ride.setStartedAt(LocalDateTime.now());
        Ride savedRide=updateRideStatus(ride,RideStatus.ONGOING);

        return modelMapper.map(savedRide, RideDto.class);
    }

    @Override
    public RideDto endRide(Long rideId) {

        //check if ride exists
        Ride ride= rideRepository.findById(rideId).orElseThrow(
                ()-> new ResourceNotFoundException("No ride with these specification to cancel")
        );

        if(!ride.getRideStatus().equals(RideStatus.ONGOING)){
            throw new RuntimeException("Cannot End this ride as its in "+ride.getRideStatus()+" status");
        }

        Ride savedRide=updateRideStatus(ride,RideStatus.ENDED);
        //TODO after confirmation of the ride , update the availability of the driver
        return modelMapper.map(savedRide,RideDto.class);
    }

    @Override
    public RideDto cancelRideByRider(Long rideId) {

        //TODO -> get rider id by UserContext holder , right now hardcoding the values
        Long riderId=2L;

        //check if ride exists
        Ride ride= rideRepository.findById(rideId).orElseThrow(
                ()-> new ResourceNotFoundException("No ride with these specification to cancel")
        );

        if(!ride.getRiderId().equals(riderId)){
            throw new RuntimeException("Rider cannot cancel this ride, due to id mismatch");
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Cannot Cancel this ride as its in "+ride.getRideStatus()+" status");
        }

        Ride savedRide=updateRideStatus(ride,RideStatus.CANCELLED);
        //TODO after confirmation of the ride , update the availability of the driver
        return modelMapper.map(savedRide,RideDto.class);
    }

    @Override
    public RideDto cancelRideByDriver(Long rideId) {

        //TODO -> get driver id by UserContext holder , right now hardcoding the values
        Long driverId=2L;

        //check if ride exists
        Ride ride= rideRepository.findById(rideId).orElseThrow(
                ()-> new ResourceNotFoundException("No ride with these specification to cancel")
        );

        if(!ride.getDriverId().equals(driverId)){
            throw new RuntimeException("Rider cannot cancel this ride, due to id mismatch");
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Cannot Cancel this ride as its in "+ride.getRideStatus()+" status");
        }

        Ride savedRide=updateRideStatus(ride,RideStatus.CANCELLED);
        //TODO after confirmation of the ride , update the availability of the driver
        return modelMapper.map(savedRide,RideDto.class);
    }

    @Override
    public RideDto getRideById(Long rideId) {
        //check if ride exists
        Ride ride= rideRepository.findById(rideId).orElseThrow(
                ()-> new ResourceNotFoundException("No ride with these specification to cancel")
        );
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public List<RideDto> getAllRidesOfRider() {

        //TODO -> get rider id by UserContext holder , right now hardcoding the values
        Long riderId=2L;

        Optional<List<Ride>> rides= rideRepository.findAllByRiderId(riderId);


        return rides.orElse(Collections.emptyList()) // Handle empty optional
                .stream()
                .map(ride -> modelMapper.map(ride, RideDto.class)) // Map each Ride to RideDto
                .collect(Collectors.toList());
    }

    @Override
    public List<RideDto> getAllRidesOfDriver() {

        //TODO -> get rider id by UserContext holder , right now hardcoding the values
        Long driverId=2L;

        Optional<List<Ride>> rides= rideRepository.findAllByDriverId(driverId);


        return rides.orElse(Collections.emptyList()) // Handle empty optional
                .stream()
                .map(ride -> modelMapper.map(ride, RideDto.class)) // Map each Ride to RideDto
                .collect(Collectors.toList());

    }


}
