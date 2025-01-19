package com.personnal_project_uberApp.driver_service.repository;

import com.personnal_project_uberApp.driver_service.entity.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {


    @Query(value = "SELECT d.*,ST_Distance(d.current_location, :pickUpLocation,10000) AS distance "+
            "FROM user_driver d "+
            "where available = true AND ST_DWithin(d.current_location, :pickUpLocation,10000) "+
            "ORDER BY distance "+
            "LIMIT 10", nativeQuery = true)
    List<Driver> findTenNearestDrivers(Point pickUpLocation);


    @Query(value = "SELECT * from d.* FROM user_driver d WHERE d.available=true "+
    "AND ST_DWithin(d.current_location, :pickUpLocation, 15000) "+
    "ORDER BY d.rating DESC LIMIT 10", nativeQuery = true)
    List<Driver> findTenNearbyTopRatedDrivers(Point pickUpLocation);


    Optional<Driver> findByEmail(String email);
}
