package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PharmacyBranchController {

    private final PharmacyBranchService pharmacyBranchService;

    @GetMapping("/pharmacyBranch")
    public List<PharmacyBranchDTO> getPharmacies(@RequestParam(value = "country", required = false) List<String> countries) {
        return pharmacyBranchService.getPharmacyBranch(countries);
    }

    @PostMapping("/pharmacyBranch")
    public String createPharmacyBranch(@RequestBody PharmacyBranchDTO pharmacyBranchDTO) {
        return pharmacyBranchService.createPharmacyBranch(pharmacyBranchDTO);
    }

    @PutMapping("/pharmacyBranch/{id}")
    public String updatePharmacyBranch(@RequestBody PharmacyBranchDTO pharmacyBranchDTO) {
        return pharmacyBranchService.updatePharmacyBranch(pharmacyBranchDTO);
    }
}
