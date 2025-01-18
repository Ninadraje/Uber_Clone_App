package com.personnal_project_uberApp.rider_service.services;


import com.personnal_project_uberApp.rider_service.dto.LoginRequestDto;
import com.personnal_project_uberApp.rider_service.dto.RiderDto;
import com.personnal_project_uberApp.rider_service.dto.SignupRequestDto;

public interface AuthService {

    String login(LoginRequestDto loginRequestDto);

    RiderDto signUp(SignupRequestDto signupDto);

}
