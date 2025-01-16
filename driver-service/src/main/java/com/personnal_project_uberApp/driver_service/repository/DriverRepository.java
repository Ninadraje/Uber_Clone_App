package com.personnal_project_uberApp.driver_service.repository;

import com.personnal_project_uberApp.driver_service.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
