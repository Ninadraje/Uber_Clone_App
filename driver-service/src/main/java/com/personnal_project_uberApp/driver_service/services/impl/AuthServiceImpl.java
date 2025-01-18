package com.personnal_project_uberApp.driver_service.services.impl;

import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import com.personnal_project_uberApp.driver_service.dto.LoginRequestDto;
import com.personnal_project_uberApp.driver_service.dto.SignupRequestDto;
import com.personnal_project_uberApp.driver_service.entity.Driver;
import com.personnal_project_uberApp.driver_service.exception.BadRequestException;
import com.personnal_project_uberApp.driver_service.exception.ResourceNotFoundException;
import com.personnal_project_uberApp.driver_service.repository.DriverRepository;
import com.personnal_project_uberApp.driver_service.services.AuthService;
import com.personnal_project_uberApp.driver_service.utils.PasswordUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public AuthServiceImpl(DriverRepository driverRepository, ModelMapper modelMapper, JwtService jwtService) {
        this.driverRepository = driverRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    public DriverDto signUp(SignupRequestDto signupRequestDto) {

        Driver driver = modelMapper.map(signupRequestDto, Driver.class);
        driver.setPassword(PasswordUtils.hashPassword(signupRequestDto.getPassword()));
        driver.setAvailable(true);

        Driver driverSaved = driverRepository.save(driver);
        return modelMapper.map(driverSaved, DriverDto.class);
    }

    public String login(LoginRequestDto loginRequestDto) {

        Driver driver = driverRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with email :" + loginRequestDto.getEmail())
                );

        boolean isPasswordMatch = PasswordUtils.checkPassword(loginRequestDto.getPassword(), driver.getPassword());

        if (!isPasswordMatch) {
            throw new BadRequestException("Incorrect password");
        }

        return jwtService.generateAccessToken(driver);

    }
}
