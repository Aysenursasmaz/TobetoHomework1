package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.repositories.CarRepository;
import com.example.a.spring.intro.myProject.services.abstracts.CarService;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.AddCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.requests.UpdateCarRequest;
import com.example.a.spring.intro.myProject.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CarManager implements CarService {
    private CarRepository carRepository;


    @Override
    public void add(AddCarRequest request) {
        if(carRepository.existsCarByModelName(request.getModelName())){
            throw new RuntimeException("Aynı model ismine sahip 2 araç olamaz.");
        }
        Car car = new Car();
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setMileages(request.getMileages());
        car.setBrand(request.getBrand());
        carRepository.save(car);


      }


    @Override
    public void update(UpdateCarRequest request) {
        if(carRepository.existsById(request.getId())){
            throw new RuntimeException("Aynı id girilemez.");
        }
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

    @Override
    public List<GetListCarResponse> getByModelName(String name) {

        return carRepository.findByName(name).stream()
                .map((car)->new GetListCarResponse(car.getModelYear(), car.getModelName())).toList();
    }

    @Override
    public List<GetListCarResponse> getByModelYear(int year) {
        return  carRepository.findByYearBefore(year).stream()
                .filter(car-> car.getModelYear()<year)
                .map(car-> new GetListCarResponse(car.getModelYear(), car.getModelName()))
                .toList();
    }



}
