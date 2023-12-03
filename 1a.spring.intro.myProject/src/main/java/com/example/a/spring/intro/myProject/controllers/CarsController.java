package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.services.abstracts.CarService;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.AddCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.UpdateCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.responses.GetListCarResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("dto")
    public List<GetListCarResponse> getByModelName(@RequestParam String name){
        return carService.getByModelName(name);
    }
    @GetMapping("dto/year")
    public  List<GetListCarResponse>  getByModelYear(@RequestParam int year){
        return carService.getByModelYear(year);
    }

}
