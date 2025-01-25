package com.personnal_project_uberApp.ride_service.repository;


import com.personnal_project_uberApp.ride_service.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {


    Optional<List<Ride>> findAllByRiderId(Long riderId);

    Optional<List<Ride>> findAllByDriverId(Long riderId);
}
