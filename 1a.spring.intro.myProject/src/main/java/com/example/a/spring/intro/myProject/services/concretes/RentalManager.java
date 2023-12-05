package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.repositories.RentalRepository;
import com.example.a.spring.intro.myProject.services.abstracts.RentalService;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.AddRentalRequest;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.UpdateRentalRequest;
import com.example.a.spring.intro.myProject.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void add(AddRentalRequest request) {
        Rental rental = new Rental();
        rental.setPrice(request.getPrice());
        rental.setDateRented(request.getDateRented());
        rental.setDateReturned(request.getDateReturned());
        rental.setCustomer(request.getCustomer());
        rental.setPayment(request.getPayment());
        rental.setCar(request.getCar());
        rentalRepository.save(rental);


    }

    @Override
    public void update(UpdateRentalRequest request) {
        Rental rental = rentalRepository.findById(request.getId()).orElseThrow();
        rental.setPrice(request.getPrice());
        rental.setDateRented(request.getDateRented());
        rental.setDateReturned(request.getDateReturned());
        rental.setCustomer(request.getCustomer());
        rental.setPayment(request.getPayment());
        rental.setCar(request.getCar());
        rentalRepository.save(rental);
    }

    @Override
    public void delete(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rental);

    }

    @Override
    public List<Rental> getDateRented(String date) {
        return rentalRepository.findByDateRented(date);
    }

    @Override
    public List<GetListRentalResponse> getByPrice(double price) {
        return rentalRepository.findByPriceGreaterThan(price).stream()
                .map(rental->new GetListRentalResponse(rental.getDateRented(), rental.getPrice()))
                .filter(rental-> rental.getPrice()>price)
                .toList();
    }




}
