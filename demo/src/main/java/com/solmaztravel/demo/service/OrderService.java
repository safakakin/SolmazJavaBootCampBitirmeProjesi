package com.solmaztravel.demo.service;

import com.solmaztravel.demo.client.PaymentServiceClient;
import com.solmaztravel.demo.client.model.Payment;
import com.solmaztravel.demo.client.model.enums.PaymentStatus;
import com.solmaztravel.demo.configuration.RabbitMQSmsNotificationConfiguration;
import com.solmaztravel.demo.exception.SolmazTravelException;
import com.solmaztravel.demo.model.Order;
import com.solmaztravel.demo.model.User;
import com.solmaztravel.demo.model.enums.UserType;
import com.solmaztravel.demo.repository.OrderRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class OrderService {
    private static final int MAXIMUM_NUMBER_OF_TICKETS_OF_INDIVIDUAL_USERS = 5;
    private static final int MAXIMUM_NUMBER_OF_TICKETS_OF_CORPORATE_USERS = 20;
    private static final int MAXIMUM_NUMBER_OF_MALE_TICKETS_OF_CORPORATE_USERS = 2;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PaymentServiceClient paymentServiceClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQSmsNotificationConfiguration rabbitMQSmsNotificationConfiguration;
    public Order createOrder(Order order){
        Order savedOrder=order;
        validateTicketNumbers(order);
        rabbitTemplate.convertAndSend(rabbitMQSmsNotificationConfiguration.getQueueName(),savedOrder);
        /*Payment paymentResponse=paymentServiceClient.create(paymentRequest);
        if(paymentResponse.getPaymentStatus().equals(PaymentStatus.VALID)){
            System.out.println("Ödeme başarılı, siparişiniz oluşturuldu.");
            return orderRepository.save(order);
        }
        else{
            throw new SolmazTravelException("Payment declined.");
        }*/
        return orderRepository.save(order);
    }
    public List<Order> getOrdersByUserId(Integer userId){
        return orderRepository.findAllByUserId(userId);
    }
    private void validateTicketNumbers(Order order){


        if (UserType.INDIVIDUAL.equals(userService.getById(order.getUserId()).getType())) {
            if(MAXIMUM_NUMBER_OF_TICKETS_OF_INDIVIDUAL_USERS==order.getNumberOfTotalPassengers()){
                throw new SolmazTravelException("individual.user.ticket.max.size");
            }
            if(MAXIMUM_NUMBER_OF_MALE_TICKETS_OF_CORPORATE_USERS==order.getNumberOfMalePassengers()){
                throw new SolmazTravelException("individual.user.male.ticket.max.size");
            }
        }
        if (UserType.CORPORATE.equals(userService.getById(order.getUserId()).getType())) {
            if(MAXIMUM_NUMBER_OF_TICKETS_OF_CORPORATE_USERS==order.getNumberOfTotalPassengers()){
                throw new SolmazTravelException("corporate.user.ticket.max.size");
            }
        }
    }
}
