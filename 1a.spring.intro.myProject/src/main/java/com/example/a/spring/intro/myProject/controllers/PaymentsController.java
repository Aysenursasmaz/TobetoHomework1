package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.repositories.PaymentRepository;
import com.example.a.spring.intro.myProject.services.abstracts.PaymentService;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.AddPaymentRequest;
import com.example.a.spring.intro.myProject.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")

public class PaymentsController {
    private PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
  @PostMapping
    public void add(@RequestBody AddPaymentRequest request){
        paymentService.add(request);
  }
  @PutMapping("{id}")
    public void update(@RequestBody UpdatePaymentRequest request){
        paymentService.update(request);
  }
  @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentService.delete(id);
  }


}
