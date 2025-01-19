package com.personnal_project_uberApp.ride_service.dto;


import com.personnal_project_uberApp.ride_service.entities.enums.PaymentMethod;
import com.personnal_project_uberApp.ride_service.entities.enums.RideRequestStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;

    private Long riderId;

    private RideRequestStatus rideRequestStatus;

    public RideRequestDto(Long id, PointDto pickupLocation, PointDto dropOffLocation, PaymentMethod paymentMethod, LocalDateTime requestedTime, Long riderId, RideRequestStatus rideRequestStatus) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.paymentMethod = paymentMethod;
        this.requestedTime = requestedTime;
        this.riderId = riderId;
        this.rideRequestStatus = rideRequestStatus;
    }

    public RideRequestDto() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RideRequestDto)) return false;
        final RideRequestDto other = (RideRequestDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$pickupLocation = this.getPickupLocation();
        final Object other$pickupLocation = other.getPickupLocation();
        if (this$pickupLocation == null ? other$pickupLocation != null : !this$pickupLocation.equals(other$pickupLocation))
            return false;
        final Object this$dropOffLocation = this.getDropOffLocation();
        final Object other$dropOffLocation = other.getDropOffLocation();
        if (this$dropOffLocation == null ? other$dropOffLocation != null : !this$dropOffLocation.equals(other$dropOffLocation))
            return false;
        final Object this$paymentMethod = this.getPaymentMethod();
        final Object other$paymentMethod = other.getPaymentMethod();
        if (this$paymentMethod == null ? other$paymentMethod != null : !this$paymentMethod.equals(other$paymentMethod))
            return false;
        final Object this$requestedTime = this.getRequestedTime();
        final Object other$requestedTime = other.getRequestedTime();
        if (this$requestedTime == null ? other$requestedTime != null : !this$requestedTime.equals(other$requestedTime))
            return false;
        final Object this$riderId = this.getRiderId();
        final Object other$riderId = other.getRiderId();
        if (this$riderId == null ? other$riderId != null : !this$riderId.equals(other$riderId)) return false;
        final Object this$rideRequestStatus = this.getRideRequestStatus();
        final Object other$rideRequestStatus = other.getRideRequestStatus();
        if (this$rideRequestStatus == null ? other$rideRequestStatus != null : !this$rideRequestStatus.equals(other$rideRequestStatus))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RideRequestDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $pickupLocation = this.getPickupLocation();
        result = result * PRIME + ($pickupLocation == null ? 43 : $pickupLocation.hashCode());
        final Object $dropOffLocation = this.getDropOffLocation();
        result = result * PRIME + ($dropOffLocation == null ? 43 : $dropOffLocation.hashCode());
        final Object $paymentMethod = this.getPaymentMethod();
        result = result * PRIME + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
        final Object $requestedTime = this.getRequestedTime();
        result = result * PRIME + ($requestedTime == null ? 43 : $requestedTime.hashCode());
        final Object $riderId = this.getRiderId();
        result = result * PRIME + ($riderId == null ? 43 : $riderId.hashCode());
        final Object $rideRequestStatus = this.getRideRequestStatus();
        result = result * PRIME + ($rideRequestStatus == null ? 43 : $rideRequestStatus.hashCode());
        return result;
    }

    public String toString() {
        return "RideRequestDto(id=" + this.getId() + ", pickupLocation=" + this.getPickupLocation() + ", dropOffLocation=" + this.getDropOffLocation() + ", paymentMethod=" + this.getPaymentMethod() + ", requestedTime=" + this.getRequestedTime() + ", riderId=" + this.getRiderId() + ", rideRequestStatus=" + this.getRideRequestStatus() + ")";
    }
}
