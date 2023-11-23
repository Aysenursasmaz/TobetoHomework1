package com.example.a.spring.intro.myProject.services.dtos.car.requests;

import com.example.a.spring.intro.myProject.entities.Brand;
import lombok.Data;

@Data

public class UpdateCarRequest {
    private Integer id;
    private Integer modelYear;
    private String modelName;
    private Double mileages;
    private Brand brand;

}
