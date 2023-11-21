package com.example.a.spring.intro.myProject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="customers")
@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String lastName;
    @Column(name="adress")
    private String adress;
    @Column(name="mail")
    private String mail;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;
}
