package com.example.a.spring.intro.myProject.services.dtos.car.responses;

import com.example.a.spring.intro.myProject.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetListCarResponse {

    private Integer modelYear;
    private String modelName;


}
