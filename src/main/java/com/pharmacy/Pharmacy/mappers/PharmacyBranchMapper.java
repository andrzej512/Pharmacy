package com.pharmacy.Pharmacy.mappers;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PharmacyBranchMapper {
    @Autowired
    PharmacyService pharmacyService;
    @Mapping(source = "pharmacyCountry", target = "pharmacyBranchAddress.country")
    @Mapping(source = "pharmacyCity", target = "pharmacyBranchAddress.city")
    @Mapping(source = "pharmacyStreet", target = "pharmacyBranchAddress.street")
    @Mapping(source=  "pharmacyName", target = "pharmacy")
    public abstract PharmacyBranch mapPharmacyBranch(PharmacyBranchDTO pharmacyBranchDTO);

    public Pharmacy pharmacyNameToPharmacy(String pharmacyName){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(pharmacyService.getPharmacyId(pharmacyName));
        pharmacy.setName(pharmacyName);
        return pharmacy;
    }

}
