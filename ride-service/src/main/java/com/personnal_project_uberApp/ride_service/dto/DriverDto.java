package com.personnal_project_uberApp.ride_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {

    private Long id;

    private String name;

    private Double rating;

    Point currentLocation;

}