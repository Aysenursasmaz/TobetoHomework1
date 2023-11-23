package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.repositories.PaymentRepository;
import com.example.a.spring.intro.myProject.services.abstracts.PaymentService;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.AddPaymentRequest;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.stereotype.Service;

@Service

public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest request) {
        Payment payment = new Payment();
        payment.setCashPayment(request.isCashPayment());
        payment.setCreditCardPayment(request.isCreditCardPayment());
        paymentRepository.save(payment);

    }

    @Override
    public void update(UpdatePaymentRequest request) {
        Payment payment = paymentRepository.findById(request.getId()).orElseThrow();
        payment.setCashPayment(request.isCashPayment());
        payment.setCreditCardPayment(request.isCreditCardPayment());
        paymentRepository.save(payment);
    }

    @Override
    public void delete(int id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(payment);
    }

}
