package com.example.a.spring.intro.myProject.services.dtos.rental.requests;

import com.example.a.spring.intro.myProject.entities.Car;
import com.example.a.spring.intro.myProject.entities.Customer;
import com.example.a.spring.intro.myProject.entities.Payment;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data

public class AddRentalRequest {
    @Min(value = 1000,message = "Ücret min. 1000 olmalıdır")
    private double price;
    @Length(max = 10,message = "Tarih alanı gün/ay/yıl olmalıdır")
    private String dateRented;
    @Length(max = 10,message = "Tarih alanı gün/ay/yıl olmalıdır")
    private String dateReturned;
    @NotNull(message = "Alan boş bırakılamaz")
    private Car car;
    @NotBlank(message = "Alan boş bırakılamaz")
    private Customer customer;
    @Positive(message = "Ödeme yapılmalıdır")
    private Payment payment;

}
