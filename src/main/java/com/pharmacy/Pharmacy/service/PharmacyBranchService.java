package com.pharmacy.Pharmacy.service;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.exceptions.BadRequestException;
import com.pharmacy.Pharmacy.exceptions.ResourceNotFoundException;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchDTOMapper;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchMapper;
import com.pharmacy.Pharmacy.model.*;
import com.pharmacy.Pharmacy.repository.PharmacyBranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyBranchService {

    private final PharmacyBranchRepository pharmacyBranchRepository;
    @Autowired
    PharmacyBranchMapper pharmacyBranchMapper;

    public List<PharmacyBranchDTO> getPharmacyBranch(List<String> countries) {
        List<PharmacyBranch> pharmacyBranches;
        List<PharmacyBranchDTO> pharmacyAddressesDTO = new ArrayList<>();
        if (countries == null|| countries.size() == 0) {
            pharmacyBranches = pharmacyBranchRepository.findAll();
        } else pharmacyBranches = pharmacyBranchRepository.findAllByPharmacyBranchAddress_CountryIn(countries);

        pharmacyBranches.forEach(n -> pharmacyAddressesDTO.add(PharmacyBranchDTOMapper.INSTANCE.mapToPharmacyBranchDTO(n)));

        return pharmacyAddressesDTO;
    }

    public String createPharmacyBranch(PharmacyBranchDTO pharmacyBranchDTO) {

        PharmacyBranch pharmacyBranch = pharmacyBranchMapper.mapPharmacyBranch(pharmacyBranchDTO);

        if (pharmacyBranchRepository.findAll().stream().anyMatch(n -> n.equals(pharmacyBranch))) {
            throw new BadRequestException("provided data already exists in db !");
        }
        pharmacyBranchRepository.save(pharmacyBranch);
        return "pharmacy created !";
    }

    public String updatePharmacyBranch(PharmacyBranchDTO pharmacyBranchDTO) {
        PharmacyBranch pharmacyBranchInDb = pharmacyBranchRepository.findById(pharmacyBranchDTO.getPharmacyBranchId())
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy branch not found for this id : "
                        + pharmacyBranchDTO.getPharmacyBranchId()));

        PharmacyBranch pharmacyBranch = pharmacyBranchMapper.mapPharmacyBranchToUpdate(pharmacyBranchDTO);

        if (pharmacyBranchInDb.equals(pharmacyBranch)) {
            throw new BadRequestException("provided data already exists in db !");
        }
        pharmacyBranchRepository.save(pharmacyBranch);
        return "record has been updated !";
    }

    public Long getPharmacyBranchAddressId(Long pharmacyBranchId) {
        return pharmacyBranchRepository.findById(pharmacyBranchId)
                .map(n -> n.getPharmacyBranchAddress().getId()).orElse(null);
    }
}
