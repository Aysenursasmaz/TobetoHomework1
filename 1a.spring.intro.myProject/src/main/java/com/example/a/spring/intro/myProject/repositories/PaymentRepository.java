package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
