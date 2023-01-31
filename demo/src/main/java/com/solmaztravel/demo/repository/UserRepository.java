package com.solmaztravel.demo.repository;

import com.solmaztravel.demo.model.Order;
import com.solmaztravel.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User getUserById(Integer Id);
}
