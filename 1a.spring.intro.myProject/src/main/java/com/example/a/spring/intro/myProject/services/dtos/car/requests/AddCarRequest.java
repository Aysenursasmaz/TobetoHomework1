package com.example.a.spring.intro.myProject.services.dtos.car.requests;

import com.example.a.spring.intro.myProject.entities.Brand;
import lombok.Data;

@Data

public class AddCarRequest {
    private String modelName;
    private int modelYear;
    private double mileages;
    private Brand brand;
}
