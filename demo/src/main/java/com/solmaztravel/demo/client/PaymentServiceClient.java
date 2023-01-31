package com.solmaztravel.demo.client;

import com.solmaztravel.demo.client.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "solmaztravel-payment", url = "http://localhost:8081/payments")
public interface PaymentServiceClient {

    @PostMapping
    Payment create(@RequestBody Payment payment);

}
