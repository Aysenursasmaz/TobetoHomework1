package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.repositories.CustomerRepository;
import com.example.a.spring.intro.myProject.services.abstracts.CustomerService;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.AddCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.UpdateCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<GetListCustomerResponse> orderById() {
        return customerRepository.orderById();
    }

    @Override
    public List<GetListCustomerResponse> getByLastName() {
        return customerRepository.findByLastNameLike();
    }


}
