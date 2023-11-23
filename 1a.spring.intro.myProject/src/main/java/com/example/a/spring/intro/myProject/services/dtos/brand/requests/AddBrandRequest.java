package com.example.a.spring.intro.myProject.services.dtos.brand.requests;

import com.example.a.spring.intro.myProject.services.abstracts.BrandService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Data

public class AddBrandRequest {
   private String brandName;

}
