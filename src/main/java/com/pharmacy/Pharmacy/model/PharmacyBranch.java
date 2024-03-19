package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name="pharmacy_branch")
public class PharmacyBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_branch_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="pharmacy_branch_address_id")
    private PharmacyBranchAddress pharmacyBranchAddress;

    public Long getId() {
        return id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public PharmacyBranchAddress getPharmacyBranchAddress() {
        return pharmacyBranchAddress;
    }

    public void setPharmacyBranchAddress(PharmacyBranchAddress pharmacyBranchAddress) {
        this.pharmacyBranchAddress = pharmacyBranchAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PharmacyBranch)) return false;
        PharmacyBranch that = (PharmacyBranch) o;
        return Objects.equals(getPharmacy(), that.getPharmacy()) && Objects.equals(getPharmacyBranchAddress(), that.getPharmacyBranchAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPharmacy(), getPharmacyBranchAddress());
    }
}
