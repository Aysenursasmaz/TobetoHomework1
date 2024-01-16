package com.example.a.spring.intro.myProject.services.dtos.user.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data

public class UpdateUserRequest {
    private int id;
    @NotBlank(message = "İsim kısmı boş bırakılamaz ")
    private String name;
    @Length(min = 2,message = "Soyadınız en az 2 karakter olabilir")
    private String lastName;
    @Length(min = 20,message = "Adres en az 20 karakter olmalıdır")
    private String adress;
    @NotBlank(message = "Mail kısmını doldurunuz")
    private String mail;

}
