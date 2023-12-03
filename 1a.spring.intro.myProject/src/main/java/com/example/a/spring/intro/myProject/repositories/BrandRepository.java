package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.Brand;
import com.example.a.spring.intro.myProject.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository  extends JpaRepository<Brand,Integer> {
     List<Brand> findByBrandNameStartingWith(String brandName);
     @Query("Select new com.example.a.spring.intro.myProject.services.dtos.brand.responses.GetListBrandResponse(b.id,b.brandName)" +
             " from Brand b WHERE b.brandName = :brandName")
     List<GetListBrandResponse> findByName( String brandName);


}
