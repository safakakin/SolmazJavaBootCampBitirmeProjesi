package com.solmaztravel.notificationservice.model;

public class Order {
    private Integer id;
    private Integer userId;
    private Integer tripId;
    private Integer numberOfFemalePassengers;
    private Integer numberOfMalePassengers;
    private Integer numberOfTotalPassengers;
    public Order() {
    }
    public Order(Integer userId,Integer tripId, Integer numberOfFemalePassengers, Integer numberOfMalePassengers, Integer numberOfTotalPassengers) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", numberOfFemalePassengers=" + numberOfFemalePassengers +
                ", numberOfMalePassengers=" + numberOfMalePassengers +
                ", numberOfTotalPassengers=" + numberOfTotalPassengers +
                '}';
    }
}
