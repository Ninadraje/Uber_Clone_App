package com.personnal_project_uberApp.rider_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiderDto {

    private Long id;

    private String name;

    private Double rating;
}
