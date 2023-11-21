package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
