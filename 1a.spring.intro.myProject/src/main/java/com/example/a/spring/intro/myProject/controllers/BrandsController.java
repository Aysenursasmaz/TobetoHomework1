package com.example.a.spring.intro.myProject.controllers;

import com.example.a.spring.intro.myProject.entities.Brand;
import com.example.a.spring.intro.myProject.repositories.BrandRepository;
import com.example.a.spring.intro.myProject.services.abstracts.BrandService;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.AddBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.requests.UpdateBrandRequest;
import com.example.a.spring.intro.myProject.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")

public class BrandsController {
    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }


    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);

    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateBrandRequest request){
        brandService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }
    @GetMapping
    public List<Brand> getByBrandName(@RequestParam String brandName){
        return brandService.getByBrandName(brandName);

    }
    @GetMapping("dto")
    public List<GetListBrandResponse>getByName(@RequestParam String brandName){
        return brandService.getByName(brandName);
    }


    }
