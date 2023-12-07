package com.example.a.spring.intro.myProject.services.dtos.payment.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class AddPaymentRequest {
    @NotNull(message = "Ödeme işlemini seçiniz")
    private boolean cashPayment;
    @NotNull(message = "Ödeme işlemini seçiniz")
    private boolean creditCardPayment;

}
