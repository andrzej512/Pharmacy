package com.pharmacy.Pharmacy.service;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchDTOMapper;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchMapper;
import com.pharmacy.Pharmacy.model.*;
import com.pharmacy.Pharmacy.repository.PharmacyBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PharmacyBranchService {

    private final PharmacyBranchRepository pharmacyBranchRepository;
    @Autowired
    PharmacyBranchMapper pharmacyBranchMapper;

    @Autowired
    public PharmacyBranchService(PharmacyBranchRepository pharmacyBranchRepository) {
        this.pharmacyBranchRepository = pharmacyBranchRepository;
    }

    public List<PharmacyBranchDTO> getPharmacyBranch(List<String> countries) {
        List<PharmacyBranch> pharmacyBranches;
        List<PharmacyBranchDTO> pharmacyAddressesDTO = new ArrayList<>();
        if (countries == null) {
            pharmacyBranches = pharmacyBranchRepository.findAll();
        } else pharmacyBranches = pharmacyBranchRepository.findAllByPharmacyBranchAddress_CountryIn(countries);

        pharmacyBranches.forEach(n -> pharmacyAddressesDTO.add(PharmacyBranchDTOMapper.INSTANCE.mapToPharmacyBranchDTO(n)));

        return pharmacyAddressesDTO;
    }

    public String createPharmacyBranch(PharmacyBranchDTO pharmacyBranchDTO) {

        List<PharmacyBranch> allPharmacies = pharmacyBranchRepository.findAll();
        PharmacyBranch pharmacyBranch = pharmacyBranchMapper.mapPharmacyBranch(pharmacyBranchDTO);
        if (pharmacyBranch.getPharmacy().getId() != null &&
                allPharmacies.stream().noneMatch(n -> n.equals(pharmacyBranch))) {
            pharmacyBranchRepository.save(pharmacyBranch);
            return "pharmacy has been created !";
        } else if (pharmacyBranch.getPharmacy().getId() == null) {
            return "pharmacy name " + pharmacyBranch.getPharmacy().getName() + " does not exist !";
        } else return "pharmacy with given data already exists !";
    }
}
