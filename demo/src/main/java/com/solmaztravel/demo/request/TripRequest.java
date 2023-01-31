package com.solmaztravel.demo.request;

import com.solmaztravel.demo.model.enums.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TripRequest {

    private Integer userId;
    private String departure;
    private String destination;
    private VehicleType vehicleType;

    public TripRequest() {
    }
    public TripRequest(Integer userId, String departure, String destination, VehicleType vehicleType) {
        this.userId = userId;
        this.departure = departure;
        this.destination = destination;
        this.vehicleType = vehicleType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
