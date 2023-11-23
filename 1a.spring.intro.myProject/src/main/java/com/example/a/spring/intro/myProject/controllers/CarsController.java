package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.services.abstracts.CarService;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.AddCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        carService.add(request);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateCarRequest request){
        carService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}
