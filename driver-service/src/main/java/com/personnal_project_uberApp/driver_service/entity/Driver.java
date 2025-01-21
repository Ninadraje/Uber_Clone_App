package com.personnal_project_uberApp.driver_service.entity;


import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;


//Ninad12341

@Entity
@Table(name = "user_driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private Double rating;

    private Boolean available;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    Point currentLocation;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Double getRating() {
        return this.rating;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public Point getCurrentLocation() {
        return this.currentLocation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }
}
