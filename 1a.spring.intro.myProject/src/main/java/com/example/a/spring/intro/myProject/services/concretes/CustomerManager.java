package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.repositories.CustomerRepository;
import com.example.a.spring.intro.myProject.services.abstracts.CustomerService;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.AddCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.UpdateCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service

public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        if (customerRepository.existsByMail(request.getMail())){
            throw new RuntimeException("Farklı bir mail adresi girin");
        }
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setLastName(request.getLastName());
        customer.setAdress(request.getAdress());
        customer.setMail(request.getMail());
        customerRepository.save(customer);
        
    }


    @Override
    public void update(UpdateCustomerRequest request) {
        if(customerRepository.existsByAdress(request.getAdress())){
            throw new RuntimeException("Aynı adresi giremezsiniz");
        }
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

        return customerRepository.orderById().stream()
                .map(customer->new GetListCustomerResponse(customer.getId(), customer.getLastName()))
                .sorted(Comparator.comparing(GetListCustomerResponse::getId)).toList();
    }

    @Override
    public List<GetListCustomerResponse> getByLastName() {
        return customerRepository.findByLastNameLike().stream()
                        .map(customer->new GetListCustomerResponse(customer.getId(), customer.getLastName()))
                        .filter(customer->customer.getLastName().contains("s")).toList();


    }


}
