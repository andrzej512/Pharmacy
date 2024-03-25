package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Entity(name = "pharmacy_branch_address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
