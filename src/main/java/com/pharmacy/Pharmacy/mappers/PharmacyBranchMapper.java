package com.pharmacy.Pharmacy.mappers;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.model.Pharmacy;
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
    @Mapping(source=  "pharmacyName", target = "pharmacy",qualifiedByName = "pharmacyNameToPharmacy")
    public abstract PharmacyBranch mapPharmacyBranch(PharmacyBranchDTO pharmacyBranchDTO);

    @Named("pharmacyNameToPharmacy")
    public Pharmacy pharmacyNameToPharmacy(String pharmacyName){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(pharmacyService.getPharmacyId(pharmacyName));
        pharmacy.setName(pharmacyName);
        return pharmacy;
    }
    @InheritConfiguration
    @Mapping(source=  "pharmacyId", target = "id")
    @Mapping(source=  "pharmacyId", target = "pharmacyBranchAddress.id",
            qualifiedByName = "pharmacyIdToPharmacyBranchAddress_Id")
    public abstract PharmacyBranch mapPharmacyBranchToUpdate(PharmacyBranchDTO pharmacyBranchDTO);

    @Named("pharmacyIdToPharmacyBranchAddress_Id")
    public Long pharmacyIdToPharmacyBranchAddress_Id(Long id){
        return pharmacyBranchService.getPharmacyBranchAddressId(id);
    }

}
