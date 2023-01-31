package com.solmaztravel.demo.repository;

import com.solmaztravel.demo.model.Trip;
import com.solmaztravel.demo.model.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findAllByVehicleType(VehicleType type);
    List<Trip> findAllByTripDate(LocalDateTime date);

}

