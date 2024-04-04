package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.dto.PharmacyDTO;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/pharmacy")
    public String createPharmacy(@RequestBody PharmacyDTO pharmacyDTO){
        return pharmacyService.createPharmacy(pharmacyDTO);
    }
}
