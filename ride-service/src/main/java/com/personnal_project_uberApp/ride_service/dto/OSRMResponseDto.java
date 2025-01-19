package com.personnal_project_uberApp.ride_service.dto;


import lombok.Data;

import java.util.List;

@Data
public class OSRMResponseDto {

    private List<OSRMRoute> routes;
}

