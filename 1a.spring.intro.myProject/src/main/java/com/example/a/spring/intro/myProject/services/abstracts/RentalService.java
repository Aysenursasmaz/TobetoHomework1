package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.services.dtos.rental.requests.AddRentalRequest;
import com.example.a.spring.intro.myProject.services.dtos.rental.requests.UpdateRentalRequest;

public interface RentalService {
    void add(AddRentalRequest request);

    void update(UpdateRentalRequest request);

    void delete(int id);

}
