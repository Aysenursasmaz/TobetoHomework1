package com.example.a.spring.intro.myProject.services.dtos.rental.requests;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.entities.Payment;
import lombok.Data;

@Data

public class AddRentalRequest {
    private double price;
    private String dateRented;
    private String dateReturned;
    private Car car;
    private Customer customer;
    private Payment payment;

}
