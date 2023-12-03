package com.example.a.spring.intro.myProject.services.dtos.brand.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetListBrandResponse {
    private int id;
    private String brandName;
}
