package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.repositories.CarRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @GetMapping
    public List<Car> getAll(){
        List<Car> cars =carRepository.findAll();
        return cars;
    }
    @GetMapping("{id}")
    public Car getById(@PathVariable int id){

        return carRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Car car){

        carRepository.save(car);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car) {
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setModelYear(car.getModelYear());
        carToUpdate.setMileages(car.getMileages());
        carToUpdate.setModelName(car.getYear());
        carToUpdate.setBrand(car.getBrand());
        carRepository.save(carToUpdate);
    }




}
