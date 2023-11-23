package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.services.dtos.brand.requests.AddBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.UpdateBrandRequest;

public interface BrandService {
    void add(AddBrandRequest request);

    void update(UpdateBrandRequest request);

    void delete(int id);

}
