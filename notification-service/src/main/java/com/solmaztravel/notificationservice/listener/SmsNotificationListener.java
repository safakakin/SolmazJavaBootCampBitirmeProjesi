package com.solmaztravel.notificationservice.listener;

import com.solmaztravel.notificationservice.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationListener {

    @RabbitListener(queues = "com.solmaztravel.notification.sms")
    public void smsNotificationListener(Order order){

        System.out.println("Sms gönderildi");
    }
}
