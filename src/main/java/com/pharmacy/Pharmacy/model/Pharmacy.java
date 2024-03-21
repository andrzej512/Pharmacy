package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "pharmacies")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private Long id;
    @Column(unique = true)
    private String name;
}
