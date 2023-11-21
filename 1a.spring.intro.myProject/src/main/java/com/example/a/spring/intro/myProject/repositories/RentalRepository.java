package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
