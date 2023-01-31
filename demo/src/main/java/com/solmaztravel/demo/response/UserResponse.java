package com.solmaztravel.demo.response;

import com.solmaztravel.demo.model.enums.UserType;

public class UserResponse {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private UserType type;

    public UserResponse() {
    }

    public UserResponse(Integer id, String name, String surname, String email, UserType type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
