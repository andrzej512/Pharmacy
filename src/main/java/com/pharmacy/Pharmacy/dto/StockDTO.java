package com.pharmacy.Pharmacy.dto;

import jakarta.persistence.*;

public class StockDTO {

    //private Medicine medicineId;

    //private PharmacyAddress pharmacyAddressId;
    private Integer availableOnStock;

    public Integer getAvailableOnStock() {
        return availableOnStock;
    }

    public void setAvailableOnStock(Integer availableOnStock) {
        this.availableOnStock = availableOnStock;
    }
}
