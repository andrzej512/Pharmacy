package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
}
