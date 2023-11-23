package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Brand;
import com.example.a.spring.intro.myProject.repositories.BrandRepository;
import com.example.a.spring.intro.myProject.services.abstracts.BrandService;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.AddBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.stereotype.Service;

@Service

public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    @Override
    public void add(AddBrandRequest request) {

        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
    Brand brand = brandRepository.findById(request.getId()).orElseThrow();
    brand.setBrandName(request.getBrandName());
    brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);

    }


}
