package com.pharmacy.Pharmacy.service;

import com.pharmacy.Pharmacy.dto.PharmacyDTO;
import com.pharmacy.Pharmacy.exceptions.BadRequestException;
import com.pharmacy.Pharmacy.exceptions.ResourceNotFoundException;
import com.pharmacy.Pharmacy.mappers.PharmacyDTOToPharmacyMapper;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public List<Pharmacy> getPharmacies() {
        return pharmacyRepository.findAll();
    }

    public String createPharmacy(PharmacyDTO pharmacyDTO) {

        Pharmacy newPharmacy = PharmacyDTOToPharmacyMapper.INSTANCE.mapToPharmacy(pharmacyDTO);

        if (pharmacyRepository.findAll().stream().anyMatch(n -> n.equals(newPharmacy))) {
            throw new BadRequestException("provided data already exists in db !");
        }
        pharmacyRepository.save(newPharmacy);
        return "New pharmacy has been added !";
    }

    public Long getPharmacyId(String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findOneByName(pharmacyName).
                orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found !"));
        return pharmacy.getId();
    }
}
