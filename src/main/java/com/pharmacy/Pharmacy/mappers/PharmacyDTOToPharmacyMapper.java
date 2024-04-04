package com.pharmacy.Pharmacy.mappers;

import com.pharmacy.Pharmacy.dto.PharmacyDTO;
import com.pharmacy.Pharmacy.model.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PharmacyDTOToPharmacyMapper {
    PharmacyDTOToPharmacyMapper INSTANCE = Mappers.getMapper(PharmacyDTOToPharmacyMapper.class);

    @Mapping(source = "newPharmacyName", target = "name")
    Pharmacy mapToPharmacy(PharmacyDTO pharmacyDTO);
}