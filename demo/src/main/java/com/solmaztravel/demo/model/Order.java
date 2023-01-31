package com.solmaztravel.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "trip_id")
    private Integer tripId;
    @Column(name = "number_of_female_passengers")
    private Integer numberOfFemalePassengers;
    @Column(name = "number_of_male_passengers")
    private Integer numberOfMalePassengers;
    @Column(name = "number_of_total_passengers")
    private Integer numberOfTotalPassengers;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false,updatable = false, nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id", insertable = false,updatable = false, nullable = false)
    private Trip trip;
    public Order() {
    }
    public Order(Integer userId,Integer tripId, Integer numberOfFemalePassengers, Integer numberOfMalePassengers, Integer numberOfTotalPassengers) {

        this.userId=userId;
        this.tripId=tripId;
        this.numberOfFemalePassengers = numberOfFemalePassengers;
        this.numberOfMalePassengers = numberOfMalePassengers;
        this.numberOfTotalPassengers = numberOfTotalPassengers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Integer getNumberOfFemalePassengers() {
        return numberOfFemalePassengers;
    }

    public void setNumberOfFemalePassengers(Integer numberOfFemalePassengers) {
        this.numberOfFemalePassengers = numberOfFemalePassengers;
    }

    public Integer getNumberOfMalePassengers() {
        return numberOfMalePassengers;
    }

    public void setNumberOfMalePassengers(Integer numberOfMalePassengers) {
        this.numberOfMalePassengers = numberOfMalePassengers;
    }

    public Integer getNumberOfTotalPassengers() {
        return numberOfTotalPassengers;
    }

    public void setNumberOfTotalPassengers(Integer numberOfTotalPassengers) {
        this.numberOfTotalPassengers = numberOfTotalPassengers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
