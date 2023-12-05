package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.Brand;
import com.example.a.spring.intro.myProject.repositories.BrandRepository;
import com.example.a.spring.intro.myProject.services.abstracts.BrandService;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.AddBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.UpdateBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Brand> getByBrandName(String brandName) {
        return brandRepository.findByBrandNameStartingWith(brandName);
    }

    @Override
    public List<GetListBrandResponse> getByName(String brandName)
    {
        return brandRepository.findByName(brandName).stream().map((brand)-> new GetListBrandResponse(brand.getId(),brand.getBrandName()))
                .toList();
    }


}
