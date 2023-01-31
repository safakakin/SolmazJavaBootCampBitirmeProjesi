package com.solmaztravel.demo.repository;

import com.solmaztravel.demo.model.Order;
import com.solmaztravel.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByUserId(Integer userId);

}
