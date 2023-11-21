package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository  extends JpaRepository<Brand,Integer> {


}
