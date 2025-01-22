package com.personnal_project_uberApp.ride_service.controller;


import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.dto.StartRideDto;
import com.personnal_project_uberApp.ride_service.services.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RideController {


    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }


    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto) {
        return ResponseEntity.ok(rideService.requestRide(rideRequestDto));
    }

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDto> acceptRideRequest(@PathVariable Long rideRequestId){
        return ResponseEntity.ok(rideService.acceptRideRequest(rideRequestId));
    }

    @PostMapping("/startRide/{rideId}")
    public ResponseEntity<RideDto> startRide(@PathVariable Long rideId, @RequestBody StartRideDto startRideDto){
        return ResponseEntity.ok(rideService.startRide(rideId,startRideDto));
    }


}
