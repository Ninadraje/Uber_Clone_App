package com.personnal_project_uberApp.driver_service.services.impl;

import com.personnal_project_uberApp.driver_service.dto.DriverDto;
import com.personnal_project_uberApp.driver_service.dto.PointDto;
import com.personnal_project_uberApp.driver_service.entity.Driver;
import com.personnal_project_uberApp.driver_service.repository.DriverRepository;
import com.personnal_project_uberApp.driver_service.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {


    private final DriverRepository driverRepository;

    private final ModelMapper modelMapper;

    @Override
    public String rateADriver(Long riderId, int rating) {
        return "";
    }

    @Override
    public DriverDto getAProfile() {
        return null;
    }

    @Override
    public DriverDto updateProfile() {
        return null;
    }

    @Override
    public List<Long> findTenNearestDrivers(PointDto pickUpLocation) {

        Point pickUpLocationPont=modelMapper.map(pickUpLocation,Point.class);

        List<Driver> driverList=driverRepository.findTenNearestDrivers(pickUpLocationPont);
        List<Long> driverId= new ArrayList<>();

        driverList.forEach(driver -> driverId.add(driver.getId()));
        return driverId;
    }

    @Override
    public List<Long> findTenNearbyTopRatedDrivers(Point pickUpLocation) {
        List<Driver> driverList=driverRepository.findTenNearbyTopRatedDrivers(pickUpLocation);

        List<Long> driverId= new ArrayList<>();

        driverList.forEach(driver -> driverId.add(driver.getId()));
        return driverId;
    }
}
