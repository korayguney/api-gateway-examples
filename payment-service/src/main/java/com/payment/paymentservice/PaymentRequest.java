package com.payment.paymentservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private BigDecimal amount;
    private String currencyCode;

    private String holder;
    private String pan;
    private String validMonth;
    private String validYear;
    private String cvv;
}
