package com.personnal_project_uberApp.ride_service.services.impl;

import com.personnal_project_uberApp.ride_service.dto.OSRMResponseDto;
import com.personnal_project_uberApp.ride_service.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class DistanceServiceImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL ="http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {
        //calculate third party api OSRM to calculate distance

        String uri= src.getX()+","+ src.getY()+";"+ dest.getX()+","+ dest.getY();

        try {
            OSRMResponseDto osrmResponseDto = RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            assert osrmResponseDto != null;
            return osrmResponseDto.getRoutes().getFirst().getDistance();
        }catch (Exception e){
            throw new RuntimeException("Error gettin data from OSRM"+ e.getMessage());
        }
    }
}
