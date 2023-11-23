package com.example.a.spring.intro.myProject.services.dtos.payment.requests;

import lombok.Data;

@Data

public class AddPaymentRequest {
    private boolean cashPayment;
    private boolean creditCardPayment;

}
