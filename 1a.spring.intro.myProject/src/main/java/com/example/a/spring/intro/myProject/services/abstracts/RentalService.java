package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.AddRentalRequest;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.UpdateRentalRequest;
import com.example.a.spring.intro.myProject.services.dtos.rental.responses.GetListRentalResponse;

import java.util.List;

public interface RentalService {
    void add(AddRentalRequest request);

    void update(UpdateRentalRequest request);

    void delete(int id);
   List <Rental> getDateRented(String date);
   List<GetListRentalResponse> getByPrice(double price);
}
