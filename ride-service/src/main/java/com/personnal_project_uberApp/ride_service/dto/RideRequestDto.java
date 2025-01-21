package com.personnal_project_uberApp.ride_service.dto;


import com.personnal_project_uberApp.ride_service.entities.enums.PaymentMethod;
import com.personnal_project_uberApp.ride_service.entities.enums.RideRequestStatus;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;

    private Long riderId;

    private Double fare;

    private RideRequestStatus rideRequestStatus;

}
