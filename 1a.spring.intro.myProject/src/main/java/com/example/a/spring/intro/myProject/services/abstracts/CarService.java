package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.services.dtos.car.requests.AddCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.UpdateCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);

    void update(UpdateCarRequest request);

    void delete(int id);
    List<GetListCarResponse> getByModelName(String name);
    List<GetListCarResponse>  getByModelYear(int year);
}

