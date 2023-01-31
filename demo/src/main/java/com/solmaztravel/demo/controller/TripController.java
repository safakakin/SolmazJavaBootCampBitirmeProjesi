package com.solmaztravel.demo.controller;

import com.solmaztravel.demo.model.Trip;
import com.solmaztravel.demo.model.User;
import com.solmaztravel.demo.request.TripRequest;
import com.solmaztravel.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/trips")
public class TripController {
    @Autowired
    private TripService tripService;
    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody TripRequest tripRequest){
        Trip savedTrip=tripService.createTrip(tripRequest);
        return new ResponseEntity<Trip>(savedTrip,HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> cancelTrip(@RequestBody Trip trip){
        tripService.cancelTrip(trip);
        return new ResponseEntity<>(OK);
    }
    @GetMapping(value="/ticketsales")
    public ResponseEntity<Integer> getTicketSalesByTrip(@RequestBody Trip trip){
        Integer ticketSales=tripService.getTicketSalesByTrip(trip);
        return new ResponseEntity<Integer>(ticketSales, OK);
    }
    @GetMapping(value="/revenue")
    public ResponseEntity<Double> getRevenueByTrip(@RequestBody Trip trip){
        Double revenue=tripService.getRevenueByTrip(trip);
        return new ResponseEntity<Double>(revenue, OK);
    }

    @GetMapping(value="/cities")
    public ResponseEntity<List<Trip>> getTripsByDepartureandDestination(@RequestBody Trip trip){
        List<Trip> trips=tripService.getTripsByDepartureandDestination(trip.getDeparture(),trip.getDestination());
                return new ResponseEntity<List<Trip>>(trips,OK);
    }

    @GetMapping(value="/vehicletype")
    public ResponseEntity<List<Trip>> getTripsByVehicleType(@RequestBody Trip trip){
        List<Trip> trips=tripService.getTripsByVehicleType(trip.getVehicleType());
        return new ResponseEntity<List<Trip>>(trips,OK);
    }

    @GetMapping(value="/datesearch")
    public ResponseEntity<List<Trip>> getTripsByTripDate(@RequestBody Trip trip){
        List<Trip> trips=tripService.getTripsByTripDate(trip.getTripDate());
        return new ResponseEntity<List<Trip>>(trips,OK);
    }
}
