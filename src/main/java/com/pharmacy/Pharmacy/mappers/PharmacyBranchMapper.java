package com.pharmacy.Pharmacy.mappers;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PharmacyBranchMapper {
    @Autowired
    PharmacyService pharmacyService;
    @Autowired
    @Lazy
    PharmacyBranchService pharmacyBranchService;

    @Mapping(source = "pharmacyCountry", target = "pharmacyBranchAddress.country")
    @Mapping(source = "pharmacyCity", target = "pharmacyBranchAddress.city")
    @Mapping(source = "pharmacyStreet", target = "pharmacyBranchAddress.street")
    @Mapping(source = "pharmacyName", target = "pharmacy.id", qualifiedByName = "pharmacyNameToPharmacyId")
    @Mapping(source = "pharmacyName", target = "pharmacy.name")
    public abstract PharmacyBranch mapPharmacyBranch(PharmacyBranchDTO pharmacyBranchDTO);

    @Named("pharmacyNameToPharmacyId")
    public Long pharmacyNameToPharmacyId(String pharmacyName) {
        return pharmacyService.getPharmacyId(pharmacyName);
    }

    @InheritConfiguration
    @Mapping(source = "pharmacyBranchId", target = "id")
    @Mapping(source = "pharmacyBranchId", target = "pharmacyBranchAddress.id",
            qualifiedByName = "pharmacyBranchIdToPharmacyBranchAddressId")
    public abstract PharmacyBranch mapPharmacyBranchToUpdate(PharmacyBranchDTO pharmacyBranchDTO);

    @Named("pharmacyBranchIdToPharmacyBranchAddressId")
    public Long pharmacyBranchIdToPharmacyBranchAddressId(Long id) {
        return pharmacyBranchService.getPharmacyBranchAddressId(id);
    }
}
