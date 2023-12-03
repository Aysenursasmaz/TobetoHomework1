package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.services.dtos.payment.responses.GetListPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query("Select new com.example.a.spring.intro.myProject.services.dtos.payment.responses.GetListPaymentResponse(p.cashPayment,p.creditCardPayment)" +
            " from Payment p ")
    List<GetListPaymentResponse> findPaymentAll();
    List<Payment> findBycashPaymentIs(boolean payment);

}
