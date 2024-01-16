package com.example.a.spring.intro.myProject.services.dtos.user.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddUserRequest {
    @NotBlank(message = "İsim kısmı boş bırakılamaz ")
    private String name;
    @Length(min = 2,message = "Soyadınız en az 2 karakter olabilir")
    private String lastName;
    @Length(min = 20,message = "Adres en az 20 karakter olmalıdır")
    private String adress;
    @NotNull(message = "Mail kısmını doldurunuz")
    private String mail;

}
