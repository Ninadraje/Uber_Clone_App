package com.personnal_project_uberApp.ride_service.repository;


import com.personnal_project_uberApp.ride_service.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
