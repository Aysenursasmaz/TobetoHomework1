package com.example.a.spring.intro.myProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="payments")
@Entity
@Getter
@Setter

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
     @Column(name="cash_payment")
     private boolean cashPayment;

     @Column(name="creditcard_payment")
    private boolean creditCardPayment;

     @OneToMany(mappedBy = "payment")
     @JsonIgnore
    private List<Rental> rentals;



}
