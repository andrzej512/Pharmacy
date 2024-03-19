package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;

@Entity(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "medicine_form")
    private MedicineForm medicineForm;
}
