package com.solmaztravel.demo.controller;

import com.solmaztravel.demo.client.model.Payment;
import com.solmaztravel.demo.client.model.enums.PaymentStatus;
import com.solmaztravel.demo.client.model.enums.PaymentType;
import com.solmaztravel.demo.model.Order;
import com.solmaztravel.demo.model.User;
import com.solmaztravel.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        /*Payment paymentRequest=new Payment();
        paymentRequest.setId(1);
        paymentRequest.setPaymentStatus(PaymentStatus.VALID);
        paymentRequest.setPaymentType(PaymentType.MONEY_ORDER);*/
        Order savedOrder=orderService.createOrder(order);
        return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Order>> getOrdersByUserId(@RequestBody Order order){
        List<Order> orders=orderService.getOrdersByUserId(order.getUserId());
        return new ResponseEntity<List<Order>>(orders, HttpStatus.CREATED);
    }

}
