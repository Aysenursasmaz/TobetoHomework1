package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
