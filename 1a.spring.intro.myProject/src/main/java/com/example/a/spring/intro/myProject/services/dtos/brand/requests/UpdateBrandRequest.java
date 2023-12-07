package com.example.a.spring.intro.myProject.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class UpdateBrandRequest {
    @NotNull(message = "id numarası boş olamaz")
    private int id;
    @NotBlank(message = "marka ismi boş olamaz")
    private String brandName;
}
