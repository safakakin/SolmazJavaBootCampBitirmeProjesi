package com.solmaztravel.paymentservice.repository;

import com.solmaztravel.paymentservice.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private static List<Payment> payments=new ArrayList<>();

    public void save(Payment payment){
        payments.add(payment);
        System.out.println("PaymentRepository :: ödeme gerçekleşti"+payment.toString());
    }
}
