package com.example.a.spring.intro.myProject.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetListCustomerResponse {
    private int id;
    private String lastName;
}
