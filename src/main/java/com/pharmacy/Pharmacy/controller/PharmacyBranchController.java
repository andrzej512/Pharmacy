package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class PharmacyBranchController {

    private final PharmacyBranchService pharmacyBranchService;

    @Autowired
    public PharmacyBranchController(PharmacyBranchService pharmacyBranchService) {
        this.pharmacyBranchService = pharmacyBranchService;
    }

    @GetMapping("/pharmacyBranch")
    public List<PharmacyBranchDTO> getPharmacies(@RequestParam(value = "country", required = false) List<String> countries) {
        return pharmacyBranchService.getPharmacyBranch(countries);
    }

    @PostMapping("/pharmacyBranch")
    public String createPharmacyBranch(@RequestBody PharmacyBranchDTO pharmacyBranchDTO){
        return pharmacyBranchService.createPharmacyBranch(pharmacyBranchDTO);
    }

}
