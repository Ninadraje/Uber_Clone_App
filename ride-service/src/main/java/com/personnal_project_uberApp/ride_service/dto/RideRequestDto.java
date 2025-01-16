package com.personnal_project_uberApp.ride_service.dto;


import com.personnal_project_uberApp.ride_service.entities.enums.PaymentMethod;
import com.personnal_project_uberApp.ride_service.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private Point pickupLocation;

    private Point dropOffLocation;

    private LocalDateTime requestedTime;

    private Long riderId;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;
}
