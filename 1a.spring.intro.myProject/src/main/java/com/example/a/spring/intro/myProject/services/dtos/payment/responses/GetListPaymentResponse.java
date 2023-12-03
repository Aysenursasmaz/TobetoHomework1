package com.example.a.spring.intro.myProject.services.dtos.payment.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetListPaymentResponse {
    private boolean cashPayment;
    private boolean creditCardPayment;
}
