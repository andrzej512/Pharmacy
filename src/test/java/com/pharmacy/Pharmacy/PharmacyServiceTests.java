package com.pharmacy.Pharmacy;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.exceptions.ResourceNotFoundException;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchDTOMapper;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchMapper;
import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.model.PharmacyBranchAddress;
import com.pharmacy.Pharmacy.repository.PharmacyBranchRepository;
import com.pharmacy.Pharmacy.repository.PharmacyRepository;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PharmacyServiceTests {
    TestData testData = new TestData();
    @Mock
    PharmacyRepository pharmacyRepository;
    @Mock
    PharmacyBranchRepository pharmacyBranchRepository;
    @InjectMocks
    PharmacyService pharmacyService;
    @InjectMocks
    PharmacyBranchService pharmacyBranchService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPharmacyId() {
        given(pharmacyRepository.findOneByName("PharmacyNameTest"))
                .willReturn(Optional.ofNullable(testData.pharmacies.get(0)));
        assertThat(pharmacyService.getPharmacyId("PharmacyNameTest")).isEqualTo(1L);
        assertThrows(ResourceNotFoundException.class, () -> pharmacyService.getPharmacyId("PharmacyNameNonExistingo"));
    }

    @Test
    public void testGetPharmaciesWhenPharmaciesExist() {
        given(pharmacyRepository.findAll()).willReturn(testData.pharmacies);
        assertThat(pharmacyService.getPharmacies().size()).isEqualTo(2);
    }

    @Test
    public void testGetPharmacyBranchWhenCountriesNull() {
        given(pharmacyBranchRepository.findAll()).willReturn(testData.pharmacyBranches);
        assertThat(pharmacyBranchService.getPharmacyBranch(null).size()).isEqualTo(2);
        assertThat(pharmacyBranchService.getPharmacyBranch(null).get(0)).isEqualTo(testData.expectedPharmacyBranchDTO);
    }
}
