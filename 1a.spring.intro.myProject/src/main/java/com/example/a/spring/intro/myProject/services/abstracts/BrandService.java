package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.entities.Brand;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.AddBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.UpdateBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);

    void update(UpdateBrandRequest request);

    void delete(int id);
   List<Brand> getByBrandName(String brandName);
   List<GetListBrandResponse> getByName(String brandName);
}
