package com.solmaztravel.notificationservice.listener;


import com.solmaztravel.notificationservice.model.UserRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    @RabbitListener(queues = "com.solmaztravel.notification.email")
    public void emailNotificationListener(UserRequest userRequest){
        System.out.println("Email bildirimi gönderildi ::" + userRequest.getEmail());
    }
}
