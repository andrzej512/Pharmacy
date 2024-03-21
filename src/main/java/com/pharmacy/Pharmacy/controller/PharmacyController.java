package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @GetMapping("/pharmacies")
    public List<Pharmacy> getPharmacies() {
        return pharmacyService.getPharmacies();
    }
}
