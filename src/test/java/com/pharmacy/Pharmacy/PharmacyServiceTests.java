package com.pharmacy.Pharmacy;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.exceptions.BadRequestException;
import com.pharmacy.Pharmacy.exceptions.ResourceNotFoundException;
import com.pharmacy.Pharmacy.mappers.PharmacyBranchMapper;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.repository.PharmacyBranchRepository;
import com.pharmacy.Pharmacy.repository.PharmacyRepository;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.junit.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.mockito.Mock;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PharmacyServiceTests {
    TestData testData = new TestData();
    @Mock
    PharmacyBranchMapper pharmacyBranchMapper;
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
    public void shouldReturnCorrectPharmacyIdWhenPharmacyNameExists() {
        //given
        given(pharmacyRepository.findOneByName("PharmacyNameTest"))
                .willReturn(Optional.ofNullable(testData.pharmacies.get(0)));
        //when
        Long PharmacyId = pharmacyService.getPharmacyId("PharmacyNameTest");
        //then
        assertThat(PharmacyId).isEqualTo(1L);
    }

    @Test
    public void shouldThrowExceptionWhenPharmacyNameDoesNotExist() {
        //given
        given(pharmacyRepository.findOneByName("PharmacyNameTest"))
                .willReturn(Optional.ofNullable(testData.pharmacies.get(0)));
        //when
        Exception exception = assertThrows(ResourceNotFoundException.class,
                () -> pharmacyService.getPharmacyId("NonExistantPharmacy"));
        //then
        assertEquals("Pharmacy not found !", exception.getMessage());
    }

    @Test
    public void shouldReturnPharmacyBranchDTOWhenCountryNotProvided() {
        //given
        given(pharmacyBranchRepository.findAll()).willReturn(testData.pharmacyBranches);
        //when
        PharmacyBranchDTO pharmacyBranchDTO = pharmacyBranchService.getPharmacyBranch(null).get(0);
        //then
        assertThat(pharmacyBranchDTO).isEqualTo(testData.pharmacyBranchDTO);
    }

    @Test
    public void shouldCreatePharmacyBranchWhenProvidedDataIsCorrect() {
        //given
        given(pharmacyBranchRepository.findAll()).willReturn(testData.pharmacyBranches);
        //when
        String message = pharmacyBranchService.createPharmacyBranch(testData.pharmacyBranchDTOToCreate);
        //then
        assertEquals("pharmacy created !", message);
    }

    @Test
    public void shouldNotCreateNewPharmacyBranchWhenPharmacyBranchAlreadyExists() {
        //given
        given(pharmacyBranchRepository.findAll()).willReturn(testData.pharmacyBranches);
        given(pharmacyBranchMapper.mapPharmacyBranch(any())).willReturn(testData.pharmacyBranches.get(0));
        //when
        Exception exception = assertThrows(BadRequestException.class,
                () -> pharmacyBranchService.createPharmacyBranch(testData.pharmacyBranchDTO));
        //then
        assertEquals("provided data already exists in db !", exception.getMessage());
    }

    @Test
    public void shouldUpdatePharmacyBranchWhenPharmacyBranchDtoIsCorrect() {
        //given
        PharmacyBranch testedBranch = testData.pharmacyBranches.get(0);
        given(pharmacyBranchRepository.findById(any())).willReturn(Optional.ofNullable(testedBranch));
        given(pharmacyBranchMapper.mapPharmacyBranchToUpdate(any())).willReturn(testData.expectedUpdatedPharmacyBranch);
        //when
        String result = pharmacyBranchService.updatePharmacyBranch(testData.pharmacyBranchDTOToUpdate);
        //then
        assertEquals("record has been updated !", result);
    }

    @Test
    public void shouldNotUpdaePharmacyBranchWhenPharmacyBranchAlreadyExists() {
        //given
        PharmacyBranch testedBranch = testData.pharmacyBranches.get(0);
        given(pharmacyBranchRepository.findById(any())).willReturn(Optional.ofNullable(testedBranch));
        given(pharmacyBranchMapper.mapPharmacyBranchToUpdate(any())).willReturn(testedBranch);
        //when
        Exception exception = assertThrows(BadRequestException.class,
                () -> pharmacyBranchService.updatePharmacyBranch(testData.pharmacyBranchDTO));
        //then
        assertEquals("provided data already exists in db !", exception.getMessage());
    }

}
