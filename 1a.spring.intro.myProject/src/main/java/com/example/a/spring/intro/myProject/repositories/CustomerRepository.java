package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT NEW com.example.a.spring.intro.myProject.services.dtos.customer.responses.GetListCustomerResponse(cu.id, cu.lastName) " +
            "FROM Customer cu ORDER BY cu.id DESC")
    List<GetListCustomerResponse> orderById();
    @Query("Select NEW com.example.a.spring.intro.myProject.services.dtos.customer.responses.GetListCustomerResponse(cu.id, cu.lastName)" +
            "FROM Customer cu WHERE cu.lastName LIKE 's%'")
    List<GetListCustomerResponse> findByLastNameLike();
}
