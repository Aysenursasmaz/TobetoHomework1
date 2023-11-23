package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.repositories.PaymentRepository;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.AddPaymentRequest;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.UpdatePaymentRequest;

public interface PaymentService {

    void add(AddPaymentRequest request);

    void update(UpdatePaymentRequest request);

    void delete(int id);

}
