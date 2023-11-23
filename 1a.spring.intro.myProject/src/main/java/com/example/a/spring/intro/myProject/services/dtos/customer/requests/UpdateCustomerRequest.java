package com.example.a.spring.intro.myProject.services.dtos.customer.requests;

import lombok.Data;

@Data

public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String lastName;
    private String adress;
    private String mail;

}
