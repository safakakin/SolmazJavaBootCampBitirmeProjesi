package com.solmaztravel.demo.service;

import com.solmaztravel.demo.converter.TripConverter;
import com.solmaztravel.demo.exception.SolmazTravelException;
import com.solmaztravel.demo.model.Trip;
import com.solmaztravel.demo.model.User;
import com.solmaztravel.demo.model.enums.UserType;
import com.solmaztravel.demo.model.enums.VehicleType;
import com.solmaztravel.demo.repository.TripRepository;
import com.solmaztravel.demo.request.TripRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private static final int MAX_PASSENGER_CAPACITY_OF_PLANE    =   189;
    private static final int MAX_PASSENGER_CAPACITY_OF_BUS    =   45;
    private static final double PLANE_TICKET_PRICE    =   250;
    private static final double BUS_TICKET_PRICE    =   100;
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private TripConverter converter;
    public Trip createTrip(TripRequest tripRequest){
        if(isAdmin(tripRequest.getUserId())){
            Trip savedTrip=converter.convert(tripRequest);
            return tripRepository.save(savedTrip);
        }
        return null;
    }
    public void cancelTrip(Trip trip){
        if(isAdmin(trip.getUserId())) {
            tripRepository.delete(trip);
        }
    }
    public Integer getTicketSalesByTrip(Trip trip){
        if(isAdmin(trip.getUserId())){
            if (VehicleType.PLANE.equals(trip.getVehicleType())) {
                return MAX_PASSENGER_CAPACITY_OF_PLANE - trip.getPassengerCapacity();
            } else {
                return MAX_PASSENGER_CAPACITY_OF_BUS - trip.getPassengerCapacity();
            }
        }
        return null;
    }
    public Double getRevenueByTrip(Trip trip){
        if(isAdmin(trip.getUserId())) {
            if (VehicleType.PLANE.equals(trip.getVehicleType())) {
                return (MAX_PASSENGER_CAPACITY_OF_PLANE - trip.getPassengerCapacity()) * PLANE_TICKET_PRICE;
            } else {
                return (MAX_PASSENGER_CAPACITY_OF_BUS - trip.getPassengerCapacity()) * BUS_TICKET_PRICE;
            }
        }
        return null;
    }
    public List<Trip> getTripsByDepartureandDestination(String departureCity, String destinationCity){

        return tripRepository.findAll()
                .stream()
                .filter(trip-> trip.getDeparture().equals(departureCity))
                .filter(trip-> trip.getDestination().equals(destinationCity)).toList();
    }
    public List<Trip> getTripsByVehicleType(VehicleType type){
        return tripRepository.findAllByVehicleType(type);
    }
    public List<Trip> getTripsByTripDate(LocalDateTime date){
        return tripRepository.findAllByTripDate(date);
    }

    public Boolean isAdmin(Integer userId){
        return UserType.ADMIN.equals(userService.getById(userId).getType());
    }
}
