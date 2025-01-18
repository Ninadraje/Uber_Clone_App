package com.personnal_project_uberApp.ride_service.entities;


import com.personnal_project_uberApp.ride_service.entities.enums.PaymentMethod;
import com.personnal_project_uberApp.ride_service.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
public class RideRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime requestedTime;

    private Long riderId;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double fare;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    public Long getId() {
        return this.id;
    }

    public Point getPickupLocation() {
        return this.pickupLocation;
    }

    public Point getDropOffLocation() {
        return this.dropOffLocation;
    }

    public LocalDateTime getRequestedTime() {
        return this.requestedTime;
    }

    public Long getRiderId() {
        return this.riderId;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public Double getFare() {
        return this.fare;
    }

    public RideRequestStatus getRideRequestStatus() {
        return this.rideRequestStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPickupLocation(Point pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropOffLocation(Point dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setRequestedTime(LocalDateTime requestedTime) {
        this.requestedTime = requestedTime;
    }

    public void setRiderId(Long riderId) {
        this.riderId = riderId;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public void setRideRequestStatus(RideRequestStatus rideRequestStatus) {
        this.rideRequestStatus = rideRequestStatus;
    }
}
