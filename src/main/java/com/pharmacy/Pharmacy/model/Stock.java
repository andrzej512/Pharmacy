package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;

@Entity(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicineId;
    @ManyToOne()
    @JoinColumn(name = "pharmacy_branch_id")
    private PharmacyBranch pharmacyBranchId;
    private Integer onStock;

    public Long getId() {
        return id;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public PharmacyBranch getPharmacyAddressId() {
        return pharmacyBranchId;
    }

    public Integer getOnStock() {
        return onStock;
    }
}
