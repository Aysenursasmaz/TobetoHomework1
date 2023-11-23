package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.services.dtos.customer.requests.AddCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest request);

    void update(UpdateCustomerRequest request);

    void delete(int id);

}
