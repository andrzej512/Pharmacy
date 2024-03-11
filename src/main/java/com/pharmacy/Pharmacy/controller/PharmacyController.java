package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PharmacyController {

    private final PharmacyService pharmacyService;
    @Autowired
    public PharmacyController(PharmacyService pharmacyService){
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/pharmacies")
    public List<Pharmacy> getPharmacies() {
        return pharmacyService.getPharmacies();
    }
}
