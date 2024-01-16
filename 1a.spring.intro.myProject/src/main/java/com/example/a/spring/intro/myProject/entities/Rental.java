package com.example.a.spring.intro.myProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="rental")
@Entity
@Getter
@Setter

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="price")
    private double price;
    @Column(name="date_rented")
    private String dateRented;

    @Column(name="date_returned")
    private String dateReturned;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="payment_id")
    private Payment payment;
}
