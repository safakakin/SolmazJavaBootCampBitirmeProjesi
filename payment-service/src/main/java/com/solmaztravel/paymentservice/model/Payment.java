package com.solmaztravel.paymentservice.model;

import com.solmaztravel.paymentservice.model.enums.PaymentStatus;
import com.solmaztravel.paymentservice.model.enums.PaymentType;

public class Payment {

    private Integer id;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(Integer id, PaymentType paymentType,PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentType = paymentType;
        this.paymentStatus=paymentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
