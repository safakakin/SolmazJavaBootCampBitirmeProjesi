package com.solmaztravel.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.solmaztravel.demo.model.enums.VehicleType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="trips")
public class Trip   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer Id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name = "departure")
    private String departure;
    @Column(name = "destination")
    private String destination;
    @Column(name = "vehicle_type")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tripDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderList;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false,updatable = false, nullable = false)
    private User user;


    public Trip() {
    }
    public Trip(Integer userId, String departure, String destination, VehicleType vehicleType) {
        this.userId=userId;
        this.departure = departure;
        this.destination = destination;
        this.vehicleType = vehicleType;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
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
    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    public LocalDateTime getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
