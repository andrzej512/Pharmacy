package com.pharmacy.Pharmacy.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PharmacyBranchDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long pharmacyBranchId;
    private String pharmacyCountry;
    private String pharmacyCity;
    private String pharmacyStreet;
    private String pharmacyName;
}
