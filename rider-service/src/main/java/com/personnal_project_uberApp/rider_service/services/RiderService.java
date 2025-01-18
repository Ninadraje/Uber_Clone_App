package com.personnal_project_uberApp.rider_service.services;

import com.personnal_project_uberApp.rider_service.dto.RiderDto;

public interface RiderService {


    String rateARider(Long riderId);

    RiderDto getMyProfile();

    RiderDto updateProfile();

}
