package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.repositories.CustomerRepository;
import com.example.a.spring.intro.myProject.services.abstracts.CustomerService;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.AddCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.requests.UpdateCustomerRequest;
import com.example.a.spring.intro.myProject.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")

public class CustomersController {
 private CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){
        customerService.add(request);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateCustomerRequest request){
        customerService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
    @GetMapping("dto")
        public List<GetListCustomerResponse> orderById(){
        return customerService.orderById();
    }
    @GetMapping("dto/lastName")
    public List<GetListCustomerResponse> getByLastName(){
        return customerService.getByLastName();
    }
}
