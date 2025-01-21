package com.personnal_project_uberApp.ride_service.services.impl;

import com.personnal_project_uberApp.ride_service.dto.OSRMResponseDto;
import com.personnal_project_uberApp.ride_service.dto.PointDto;
import com.personnal_project_uberApp.ride_service.dto.WeatherResponseDto;
import com.personnal_project_uberApp.ride_service.services.WeatherService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String WEATHER_API_URI="http://api.weatherapi.com/v1/current.json";
//key=4d278407688a4f5db00152309252101&q=48.8567,2.3508&aqi=no

    private static final String API_KEY="4d278407688a4f5db00152309252101";


    @Override
    public String weatherCondition(Point src) {

        String uri = "?"+"key="+API_KEY+"&"+"q="+src.getX()+","+src.getY()+"&api=no";

        try {
            WeatherResponseDto weatherResponseDto = RestClient.builder()
                    .baseUrl(WEATHER_API_URI)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(WeatherResponseDto.class);

            assert weatherResponseDto != null;
            return weatherResponseDto.getCurrent().getCondition().getText();
        }catch (Exception e){
            throw new RuntimeException("Error gettin data from OSRM"+ e.getMessage());
        }
    }
}
