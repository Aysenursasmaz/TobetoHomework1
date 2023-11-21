package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Payment;
import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")

public class RentalsController {
    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
    @GetMapping
    public List<Rental> getAll(){
        List<Rental> rentals = rentalRepository.findAll();
        return rentals;
    }
    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){
        return rentalRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);

    }
    @DeleteMapping
    public void delete(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);

    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rental rental){
        Rental rentalToUpdate = rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setPrice(rental.getPrice());
        rentalToUpdate .setDateRented(rental.getDateRented());
        rentalToUpdate .setDateReturned(rental.getDateReturned());
        rentalToUpdate .setCar(rental.getCar());
        rentalToUpdate .setCustomer(rental.getCustomer());
        rentalToUpdate .setPayment(rental.getPayment());
        rentalToUpdate.save(rentalToUpdate);
    }
}
