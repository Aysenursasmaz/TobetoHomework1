package com.example.a.spring.intro.myProject.services.dtos.car.requests;

import com.example.a.spring.intro.myProject.entities.Brand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddCarRequest {
    @NotNull(message = "Model adı boş bırakılamaz.")
    private String modelName;
    @Min(value = 2010,message = "Model yılı 2010 dan küçük olamaz.")
    private int modelYear;
    @Positive(message = "Km değeri pozitif olmalıdır.")
    private double mileages;
    @NotNull(message = "Marka bilgisi boş olamaz.")
    private Brand brand;
}
