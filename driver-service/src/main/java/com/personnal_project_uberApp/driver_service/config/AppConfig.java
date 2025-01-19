package com.personnal_project_uberApp.driver_service.config;

import com.personnal_project_uberApp.driver_service.dto.PointDto;
import com.personnal_project_uberApp.driver_service.utils.GeometryUtils;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(PointDto.class, Point.class)
                .setConverter(mappingContext -> {
                    PointDto pointDto = mappingContext.getSource();
                    return GeometryUtils.createPoint(pointDto);
                });

        return modelMapper;
    }
}
