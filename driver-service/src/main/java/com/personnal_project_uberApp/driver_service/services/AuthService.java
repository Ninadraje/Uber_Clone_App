package com.personnal_project_uberApp.driver_service.services;


import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import com.personnal_project_uberApp.driver_service.dto.LoginRequestDto;
import com.personnal_project_uberApp.driver_service.dto.SignupRequestDto;


public interface AuthService {

    String login(LoginRequestDto loginRequestDto);

    DriverDto signup(SignupRequestDto signupDto);

}
