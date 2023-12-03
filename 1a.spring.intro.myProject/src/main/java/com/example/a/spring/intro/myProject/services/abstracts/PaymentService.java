package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.repositories.PaymentRepository;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.AddPaymentRequest;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.UpdatePaymentRequest;
import com.example.a.spring.intro.myProject.services.dtos.payment.responses.GetListPaymentResponse;

import java.util.List;

public interface PaymentService {

    void add(AddPaymentRequest request);

    void update(UpdatePaymentRequest request);

    void delete(int id);
 List<GetListPaymentResponse> getAll();
 List<Payment> isTrue(boolean payment);
}
