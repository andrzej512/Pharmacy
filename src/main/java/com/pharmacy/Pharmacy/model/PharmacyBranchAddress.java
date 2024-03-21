package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@Entity(name = "pharmacy_branch_address")
public class PharmacyBranchAddress {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_branch_address_id")
    private Long id;
    private String country;
    private String city;
    private String street;
}
