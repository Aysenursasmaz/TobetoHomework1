package com.example.a.spring.intro.myProject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name="cars")
@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name= "model_year")
    private int modelYear;
    @Column(name="mileages")
    private double mileages;
    @Column(name="model_name")
    private String modelName;

    @OneToMany(mappedBy= "car")
    @JsonIgnore

    private List<Rental> rentals;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
}
