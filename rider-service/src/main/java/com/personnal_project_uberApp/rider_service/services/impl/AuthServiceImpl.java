package com.personnal_project_uberApp.rider_service.services.impl;

import com.personnal_project_uberApp.rider_service.dto.LoginRequestDto;
import com.personnal_project_uberApp.rider_service.dto.RiderDto;
import com.personnal_project_uberApp.rider_service.dto.SignupRequestDto;
import com.personnal_project_uberApp.rider_service.entities.Rider;
import com.personnal_project_uberApp.rider_service.exception.BadRequestException;
import com.personnal_project_uberApp.rider_service.exception.ResourceNotFoundException;
import com.personnal_project_uberApp.rider_service.repository.RiderRepository;
import com.personnal_project_uberApp.rider_service.services.AuthService;
import com.personnal_project_uberApp.rider_service.utils.PasswordUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public AuthServiceImpl(RiderRepository riderRepository, ModelMapper modelMapper, JwtService jwtService) {
        this.riderRepository = riderRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    public RiderDto signUp(SignupRequestDto signupRequestDto) {

        Rider rider = modelMapper.map(signupRequestDto, Rider.class);
        rider.setPassword(PasswordUtils.hashPassword(signupRequestDto.getPassword()));

        Rider riderSaved = riderRepository.save(rider);
        return modelMapper.map(riderSaved, RiderDto.class);
    }

    public String login(LoginRequestDto loginRequestDto) {

        Rider rider = riderRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with email :" + loginRequestDto.getEmail())
                );

        boolean isPasswordMatch = PasswordUtils.checkPassword(loginRequestDto.getPassword(), rider.getPassword());

        if (!isPasswordMatch) {
            throw new BadRequestException("Incorrect password");
        }

        return jwtService.generateAccessToken(rider);

    }
}