package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")

public class PaymentsController {
    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @GetMapping
    public List<Payment> getAll(){
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }
    @GetMapping("{id}")
    public Payment getById(@PathVariable int id){
        return paymentRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Payment payment){
        Payment paymentToUpdate = paymentRepository.findById(id).orElseThrow();
        paymentToUpdate.setCashPayment(payment.getCashPayment());
        paymentToUpdate.setCreditCardPayment(payment.getCreditCardPayment());
        paymentRepository.save(paymentToUpdate);
    }

}
