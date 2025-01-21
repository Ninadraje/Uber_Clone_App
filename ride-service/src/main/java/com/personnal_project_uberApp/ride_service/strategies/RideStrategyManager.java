package com.personnal_project_uberApp.ride_service.strategies;


import com.personnal_project_uberApp.ride_service.services.WeatherService;
import com.personnal_project_uberApp.ride_service.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.personnal_project_uberApp.ride_service.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.personnal_project_uberApp.ride_service.strategies.impl.RideDefaultFareCalculationStrategyImpl;
import com.personnal_project_uberApp.ride_service.strategies.impl.RideFareSurgePricingCalculationStrategy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideDefaultFareCalculationStrategyImpl defaultFareCalculationStrategy;
    private final RideFareSurgePricingCalculationStrategy surgePricingCalculationStrategy;
    private final WeatherService weatherService;


    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if (riderRating >= 4.0){
            return highestRatedDriverStrategy;
        }else {
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(Point src){

        boolean ifSurgeFeeApplicable=false;

        String weatherConditon=weatherService.weatherCondition(src);

        if(weatherConditon.equals("Cloudy")||weatherConditon.equals("Rainy")){
            ifSurgeFeeApplicable=true;
        }


        if(ifSurgeFeeApplicable){
            return surgePricingCalculationStrategy;
        }else {
            return defaultFareCalculationStrategy;
        }

    }


}

