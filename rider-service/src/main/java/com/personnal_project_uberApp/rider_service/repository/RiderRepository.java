package com.personnal_project_uberApp.rider_service.repository;

import com.personnal_project_uberApp.rider_service.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {
    Optional<Rider> findByEmail(String email);
}
