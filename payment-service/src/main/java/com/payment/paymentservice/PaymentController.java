package com.payment.paymentservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository repository;

    @PostMapping( "/direct")
    public Payment savePayment(@RequestBody PaymentRequest request) {
        Payment paymentEntity = Payment.builder()
                .amount(request.getAmount())
                .currencyCode(request.getCurrencyCode())
                .holder(request.getHolder())
                .cvv(request.getCvv())
                .pan(request.getPan())
                .validMonth(request.getValidMonth())
                .validYear(request.getValidYear())
                .build();
        return repository.save(paymentEntity);
    }
}
