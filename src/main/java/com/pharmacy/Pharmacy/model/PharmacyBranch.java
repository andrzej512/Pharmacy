package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "pharmacy_branch")
@Builder
@NamedEntityGraph(
        name = "PharmacyBranch.withRelations",
        attributeNodes = {
                @NamedAttributeNode("pharmacyBranchAddress"),
                @NamedAttributeNode("pharmacy")})
public class PharmacyBranch {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_branch_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_branch_address_id")
    private PharmacyBranchAddress pharmacyBranchAddress;
}
