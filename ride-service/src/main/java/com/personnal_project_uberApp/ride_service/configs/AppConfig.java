package com.personnal_project_uberApp.ride_service.configs;

import com.personnal_project_uberApp.ride_service.dto.PointDto;
import com.personnal_project_uberApp.ride_service.utils.GeometryUtils;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  AppConfig {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper= new ModelMapper();

        modelMapper.typeMap(PointDto.class, Point.class)
                .setConverter(mappingContext -> {
                    PointDto pointDto= mappingContext.getSource();
                    return GeometryUtils.createPoint(pointDto);
                });

        modelMapper.typeMap(Point.class, PointDto.class)
                .setConverter(mappingContext -> {
                   Point point=mappingContext.getSource();
                   double coordinates[]={
                           point.getX(),
                           point.getY()
                   };

                   return new PointDto(coordinates);
                });

        return modelMapper;
    }
}
