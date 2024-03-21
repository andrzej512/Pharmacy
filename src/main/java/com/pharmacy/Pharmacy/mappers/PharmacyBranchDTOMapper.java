package com.pharmacy.Pharmacy.mappers;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PharmacyBranchDTOMapper {
    PharmacyBranchDTOMapper INSTANCE = Mappers.getMapper(PharmacyBranchDTOMapper.class);

    @Mapping(source = "pharmacyBranchAddress.country", target = "pharmacyCountry")
    @Mapping(source = "pharmacyBranchAddress.city", target = "pharmacyCity")
    @Mapping(source = "pharmacyBranchAddress.street", target = "pharmacyStreet")
    @Mapping(source = "pharmacy.name", target = "pharmacyName")
    PharmacyBranchDTO mapToPharmacyBranchDTO(PharmacyBranch pharmacyBranch);
}
