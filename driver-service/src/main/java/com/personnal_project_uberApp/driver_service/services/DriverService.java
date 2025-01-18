package com.personnal_project_uberApp.driver_service.services;

import com.personnal_project_uberApp.driver_service.dto.DriverDto;

public interface DriverService {

    String rateADriver(Long riderId,int rating);

    DriverDto getAProfile();

    DriverDto updateProfile();
}
