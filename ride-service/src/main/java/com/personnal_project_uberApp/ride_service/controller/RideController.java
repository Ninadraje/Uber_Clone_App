package com.personnal_project_uberApp.ride_service.controller;


import com.personnal_project_uberApp.ride_service.dto.RideDto;
import com.personnal_project_uberApp.ride_service.dto.RideRequestDto;
import com.personnal_project_uberApp.ride_service.dto.StartRideDto;
import com.personnal_project_uberApp.ride_service.services.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RideController {


    private final RideService rideService;

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

    @PostMapping("/endRide/{rideId}")
    public ResponseEntity<RideDto> endRide(@PathVariable Long rideId){
        return  ResponseEntity.ok(rideService.endRide(rideId));
    }

    @PostMapping("/cancelRideByRider/{rideId}")
    public ResponseEntity<RideDto> cancelRideByRider(@PathVariable Long rideId){
        return  ResponseEntity.ok(rideService.cancelRideByRider(rideId));
    }

    @PostMapping("/cancelRideByDriver/{rideId}")
    public ResponseEntity<RideDto> cancelRideByDriver(@PathVariable Long rideId){
        return  ResponseEntity.ok(rideService.cancelRideByDriver(rideId));
    }

    @GetMapping("/getAllRidesOfRider")
    public ResponseEntity<List<RideDto>> getAllRidesOfRider(){
        return  ResponseEntity.ok(rideService.getAllRidesOfRider());
    }

    @GetMapping("/getAllRidesOfDriver")
    public ResponseEntity<List<RideDto>> getAllRidesOfDriver(){
        return  ResponseEntity.ok(rideService.getAllRidesOfDriver());
    }

}
