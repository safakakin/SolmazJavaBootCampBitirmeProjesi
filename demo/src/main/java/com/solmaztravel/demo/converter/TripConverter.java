package com.solmaztravel.demo.converter;

import com.solmaztravel.demo.model.Trip;
import com.solmaztravel.demo.model.enums.VehicleType;
import com.solmaztravel.demo.request.TripRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class TripConverter {

    private static final int MAX_PASSENGER_CAPACITY_OF_PLANE    =   189;
    private static final int MAX_PASSENGER_CAPACITY_OF_BUS    =   45;

    public Trip convert(TripRequest tripRequest){
        Trip trip =new Trip();
        trip.setUserId(tripRequest.getUserId());
        trip.setDeparture(tripRequest.getDeparture());
        trip.setDestination(tripRequest.getDestination());
        trip.setVehicleType(tripRequest.getVehicleType());
        trip.setCreateDate(LocalDateTime.now());
        trip.setTripDate(LocalDateTime.now());
        if(tripRequest.getVehicleType().equals(VehicleType.PLANE)){
            trip.setPassengerCapacity(MAX_PASSENGER_CAPACITY_OF_PLANE);
        }
        else{
            trip.setPassengerCapacity(MAX_PASSENGER_CAPACITY_OF_BUS);
        }
        return trip;
    }
}
