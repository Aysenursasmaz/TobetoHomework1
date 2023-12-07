package com.example.a.spring.intro.myProject.services.dtos.brand.requests;

import com.example.a.spring.intro.myProject.services.abstracts.BrandService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddBrandRequest {
   @NotBlank(message = "marka ismi boş olamaz")
   private String brandName;

}
