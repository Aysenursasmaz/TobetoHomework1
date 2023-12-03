package com.example.a.spring.intro.myProject.services.dtos.rental.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private String dateRented;
    private double price;
}
