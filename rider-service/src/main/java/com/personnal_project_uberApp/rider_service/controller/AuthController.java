package com.personnal_project_uberApp.rider_service.controller;

import com.personnal_project_uberApp.rider_service.dto.LoginRequestDto;
import com.personnal_project_uberApp.rider_service.dto.RiderDto;
import com.personnal_project_uberApp.rider_service.dto.SignupRequestDto;
import com.personnal_project_uberApp.rider_service.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<RiderDto> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        RiderDto riderDto = authService.signUp(signupRequestDto);
        return new ResponseEntity<>(riderDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> signUp(@RequestBody LoginRequestDto loginRequestDto) {

        String token = authService.login(loginRequestDto);
        return ResponseEntity.ok(token);
    }

}
