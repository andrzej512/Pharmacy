package com.pharmacy.Pharmacy.service;

import com.pharmacy.Pharmacy.exceptions.ResourceNotFoundException;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacyRepository.findAll();
    }

    public Long getPharmacyId(String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findOneByName(pharmacyName).
                orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found !"));
        return pharmacy.getId();
    }
}
