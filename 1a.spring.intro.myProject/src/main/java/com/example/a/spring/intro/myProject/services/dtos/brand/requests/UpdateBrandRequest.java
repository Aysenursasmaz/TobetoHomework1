package com.example.a.spring.intro.myProject.services.dtos.brand.requests;

import lombok.Data;

@Data

public class UpdateBrandRequest {
    private int id;
    private String brandName;
}
