package com.personnal_project_uberApp.driver_service.controller;

import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import com.personnal_project_uberApp.driver_service.dto.LoginRequestDto;
import com.personnal_project_uberApp.driver_service.dto.SignupRequestDto;
import com.personnal_project_uberApp.driver_service.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<DriverDto> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        DriverDto driverDto = authService.signUp(signupRequestDto);
        return new ResponseEntity<>(driverDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> signUp(@RequestBody LoginRequestDto loginRequestDto) {

        String token = authService.login(loginRequestDto);
        return ResponseEntity.ok(token);
    }

}
