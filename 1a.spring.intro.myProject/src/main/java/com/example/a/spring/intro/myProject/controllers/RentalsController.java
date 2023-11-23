package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.repositories.RentalRepository;
import com.example.a.spring.intro.myProject.services.abstracts.RentalService;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.AddRentalRequest;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.UpdateRentalRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")

public class RentalsController {
  private RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        rentalService.add(request);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateRentalRequest request){
        rentalService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

}
