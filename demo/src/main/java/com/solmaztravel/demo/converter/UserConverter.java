package com.solmaztravel.demo.converter;

import com.solmaztravel.demo.model.User;
import com.solmaztravel.demo.request.UserRequest;
import com.solmaztravel.demo.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserResponse convert(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setSurname(user.getSurname());
        response.setEmail(user.getEmail());
        response.setType(user.getType());
        return response;
    }

    public User convert(UserRequest userRequest, String hash){
        User user =new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getName());
        user.setPassword(hash);
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setType(userRequest.getType());
        user.setCreateDate(LocalDateTime.now());
        return user;
    }

    public List<UserResponse> convert(List<User> userList){
        List<UserResponse> userResponses=new ArrayList<>();
        userList.stream().forEach(user->userResponses.add(convert(user)));
        return userResponses;
    }

}
