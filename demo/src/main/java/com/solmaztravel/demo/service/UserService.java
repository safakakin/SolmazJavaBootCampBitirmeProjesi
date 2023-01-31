package com.solmaztravel.demo.service;

import com.solmaztravel.demo.configuration.RabbitMQEmailNotificationConfiguration;
import com.solmaztravel.demo.converter.UserConverter;
import com.solmaztravel.demo.exception.UserNotFoundException;
import com.solmaztravel.demo.model.User;
import com.solmaztravel.demo.repository.UserRepository;
import com.solmaztravel.demo.request.LoginRequest;
import com.solmaztravel.demo.request.UserRequest;
import com.solmaztravel.demo.response.UserResponse;
import com.solmaztravel.demo.util.PasswordUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EMAIL_VEYA_ŞIFRE_YANLIŞ = "Email veya şifre yanlış.";
    private static final String LOGIN_BAŞARILI = "Giriş başarılı.";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter converter;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQEmailNotificationConfiguration rabbitMQEmailNotificationConfiguration;
    public UserResponse createUser(UserRequest userRequest){
        String hash = PasswordUtil.preparePasswordHash(userRequest.getPassword(), userRequest.getEmail());
        rabbitTemplate.convertAndSend(rabbitMQEmailNotificationConfiguration.getQueueName(),userRequest);
        User savedUser=converter.convert(userRequest,hash);
        userRepository.save(savedUser);
        return converter.convert(savedUser);
    }
    public User getById(Integer userId){

        return userRepository.getUserById(userId);
    }
    public String login(LoginRequest loginRequest){
        String hash = PasswordUtil.preparePasswordHash(loginRequest.getPassword(), loginRequest.getEmail());
        User foundUser = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("kullanıcı bulunamadı"));

        String passwordHash = PasswordUtil.preparePasswordHash(loginRequest.getPassword(), loginRequest.getEmail());

        boolean isValid = PasswordUtil.validatePassword(passwordHash, foundUser.getPassword());

        return isValid ? LOGIN_BAŞARILI : EMAIL_VEYA_ŞIFRE_YANLIŞ;
    }
}
