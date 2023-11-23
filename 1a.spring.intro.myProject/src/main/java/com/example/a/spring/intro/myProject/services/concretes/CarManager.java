package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.repositories.CarRepository;
import com.example.a.spring.intro.myProject.services.abstracts.CarService;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.AddCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.stereotype.Service;

@Service

public class CarManager implements CarService {
    private CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setMileages(request.getMileages());
        car.setBrand(request.getBrand());
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        Car car = carRepository.findById(request.getId()).orElseThrow();
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setMileages(request.getMileages());
        car.setBrand(request.getBrand());
        carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }


}
