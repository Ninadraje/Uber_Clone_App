package com.personnal_project_uberApp.driver_service.dto;

import lombok.Data;

@Data
public class SignupRequestDto {
    private String name;
    private String email;
    private String password;
}
