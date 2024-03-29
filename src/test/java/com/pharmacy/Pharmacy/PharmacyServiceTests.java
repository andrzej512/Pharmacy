package com.pharmacy.Pharmacy;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.exceptions.ResourceNotFoundException;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.model.PharmacyBranchAddress;
import com.pharmacy.Pharmacy.repository.PharmacyBranchRepository;
import com.pharmacy.Pharmacy.repository.PharmacyRepository;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.junit.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PharmacyServiceTests {
    @Mock
    PharmacyRepository pharmacyRepository;
    @Mock
    PharmacyBranchRepository pharmacyBranchRepository;
    @InjectMocks
    PharmacyService pharmacyService;
    @InjectMocks
    PharmacyBranchService pharmacyBranchService;
    @Spy
    List<Pharmacy> pharmacies = Arrays.asList(
            Pharmacy.builder().id(1L).name("PharmacyTest1").build(),
            Pharmacy.builder().id(2L).name("PharmacyTest2").build());
    @Spy
    Pharmacy pharmacy = Pharmacy.builder().id(8L).name("PharmacyNameTest").build();
    @Spy
    List<PharmacyBranch> pharmacyBranches = Arrays.asList(
            PharmacyBranch.builder()
                    .id(1L)
                    .pharmacy(pharmacies.get(0))
                    .pharmacyBranchAddress(PharmacyBranchAddress.builder()
                            .id(1L)
                            .city("testCity")
                            .street("testStreet")
                            .country("testCountry").build()).build(),
            PharmacyBranch.builder()
                    .id(2L)
                    .pharmacy(pharmacies.get(1))
                    .pharmacyBranchAddress(PharmacyBranchAddress.builder()
                            .id(2L)
                            .city("testCity2")
                            .street("testStreet2")
                            .country("testCountry2").build()).build());

    @Spy
    PharmacyBranchDTO expectedPharmacyBranchDTO = PharmacyBranchDTO
            .builder()
            .pharmacyCountry(pharmacyBranches.get(0).getPharmacyBranchAddress().getCountry())
            .pharmacyCity(pharmacyBranches.get(0).getPharmacyBranchAddress().getCity())
            .pharmacyStreet(pharmacyBranches.get(0).getPharmacyBranchAddress().getStreet())
            .pharmacyName(pharmacyBranches.get(0).getPharmacy().getName())
            .build();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPharmacyId() {
        given(pharmacyRepository.findOneByName("PharmacyNameTest"))
                .willReturn(Optional.ofNullable(pharmacy));
        assertThat(pharmacyService.getPharmacyId("PharmacyNameTest")).isEqualTo(8L);
        assertThrows(ResourceNotFoundException.class, () -> pharmacyService.getPharmacyId("PharmacyNameNonExistingo"));
    }

    @Test
    public void testGetPharmaciesWhenPharmaciesExist() {
        given(pharmacyRepository.findAll()).willReturn(pharmacies);
        assertThat(pharmacyService.getPharmacies().size()).isEqualTo(2);
    }

    @Test
    public void testGetPharmacyBranchWhenCountriesNull() {
        given(pharmacyBranchRepository.findAll()).willReturn(pharmacyBranches);
        assertThat(pharmacyBranchService.getPharmacyBranch(null).size()).isEqualTo(2);
        assertThat(pharmacyBranchService.getPharmacyBranch(null).get(0)).isEqualTo(expectedPharmacyBranchDTO);
    }
}
