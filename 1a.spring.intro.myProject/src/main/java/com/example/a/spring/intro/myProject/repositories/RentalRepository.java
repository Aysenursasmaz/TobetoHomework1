package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Rental;
import com.example.a.spring.intro.myProject.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
    List<Rental> findByDateRented(String date);
    @Query("SELECT NEW com.example.a.spring.intro.myProject.services.dtos.rental.responses.GetListRentalResponse(r.dateRented, r.price) " +
            "FROM Rental r WHERE r.price > :price")
    List<GetListRentalResponse> findByPriceGreaterThan(double price);
    boolean existsByDateRented(String dateRented);

    @Override
    boolean existsById(Integer id);
}
