package com.pharmacy.Pharmacy.repository;

import com.pharmacy.Pharmacy.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByPharmacyBranchId_IdAndMedicineId_Id(Long pharmacyAddressId, Long medicineId);
}
