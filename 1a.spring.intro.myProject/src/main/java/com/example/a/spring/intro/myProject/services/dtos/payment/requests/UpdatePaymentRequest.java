package com.example.a.spring.intro.myProject.services.dtos.payment.requests;

import lombok.Data;

@Data
public class UpdatePaymentRequest {
    private int id;
    private boolean cashPayment;
    private boolean creditCardPayment;
}
