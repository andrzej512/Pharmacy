package com.pharmacy.Pharmacy;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.model.PharmacyBranchAddress;

import java.util.Arrays;
import java.util.List;

public class TestData {

    List<Pharmacy> pharmacies = createPharmacies();
    List<PharmacyBranchAddress> pharmacyBranchAddresses = createPharmacyBranchAddresses();
    List<PharmacyBranch> pharmacyBranches = createPharmacyBranches();
    PharmacyBranchDTO expectedPharmacyBranchDTO = createPharmacyBranchDTO();

    List<Pharmacy> createPharmacies() {
        return Arrays.asList(
                Pharmacy.builder().id(1L).name("PharmacyTest1").build(),
                Pharmacy.builder().id(2L).name("PharmacyTest2").build());
    }

    List<PharmacyBranchAddress> createPharmacyBranchAddresses() {
        return Arrays.asList(
                PharmacyBranchAddress.builder().id(1L).city("testCity").street("testStreet").country("testCountry").build(),
                PharmacyBranchAddress.builder().id(1L).city("testCity2").street("testStreet2").country("testCountry2").build());
    }

    List<PharmacyBranch> createPharmacyBranches() {
        return Arrays.asList(
                PharmacyBranch.builder()
                        .id(1L)
                        .pharmacy(pharmacies.get(0))
                        .pharmacyBranchAddress(pharmacyBranchAddresses.get(0)).build(),
                PharmacyBranch.builder()
                        .id(2L)
                        .pharmacy(pharmacies.get(1))
                        .pharmacyBranchAddress(pharmacyBranchAddresses.get(1)).build());
    }

    PharmacyBranchDTO createPharmacyBranchDTO() {
        return PharmacyBranchDTO
                .builder()
                .pharmacyCountry(pharmacyBranches.get(0).getPharmacyBranchAddress().getCountry())
                .pharmacyCity(pharmacyBranches.get(0).getPharmacyBranchAddress().getCity())
                .pharmacyStreet(pharmacyBranches.get(0).getPharmacyBranchAddress().getStreet())
                .pharmacyName(pharmacyBranches.get(0).getPharmacy().getName())
                .build();
    }
    PharmacyBranchDTO createNewPharmacyBranchDTO(){
        return PharmacyBranchDTO
                .builder()
                .pharmacyCountry("New Country")
                .pharmacyCity("New City")
                .pharmacyStreet("New Street")
                .pharmacyName("New Pharmacy")
                .build();
    }

}
