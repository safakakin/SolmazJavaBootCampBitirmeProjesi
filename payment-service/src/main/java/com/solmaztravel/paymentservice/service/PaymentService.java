package com.solmaztravel.paymentservice.service;

import com.solmaztravel.paymentservice.model.Payment;
import com.solmaztravel.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    public void create(Payment payment) {
        paymentRepository.save(payment);
    }
}
