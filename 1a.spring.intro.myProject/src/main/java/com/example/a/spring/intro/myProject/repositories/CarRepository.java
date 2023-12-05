package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.services.dtos.brand.responses.GetListBrandResponse;
import com.example.a.spring.intro.myProject.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query("Select new com.example.a.spring.intro.myProject.services.dtos.car.responses.GetListCarResponse(c.modelYear,c.modelName) " +
            "from Car c WHERE c.modelName= :name")
List<GetListCarResponse> findByName(String name);
    @Query("Select new com.example.a.spring.intro.myProject.services.dtos.car.responses.GetListCarResponse(c.modelYear,c.modelName)" +
            "from Car c WHERE c.modelYear<:year")

    List<GetListCarResponse> findByYearBefore(int year);
}
