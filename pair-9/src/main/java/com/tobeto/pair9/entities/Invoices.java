package com.tobeto.pair9.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "Invoices")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "create_date")
    private Date create_date;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
