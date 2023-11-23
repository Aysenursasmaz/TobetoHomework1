package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.repositories.CustomerRepository;
import com.example.a.spring.intro.myProject.services.abstracts.CustomerService;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.AddCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service

public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setLastName(request.getLastName());
        customer.setAdress(request.getAdress());
        customer.setMail(request.getMail());
        customerRepository.save(customer);
        
    }


    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(request.getId()).orElseThrow();
        customer.setName(request.getName());
        customer.setLastName(request.getLastName());
        customer.setAdress(request.getAdress());
        customer.setMail(request.getMail());
        customerRepository.save(customer);
        
    }

    @Override
    public void delete(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);


    }


}
