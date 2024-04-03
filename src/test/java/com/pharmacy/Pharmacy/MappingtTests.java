package com.pharmacy.Pharmacy;

import com.pharmacy.Pharmacy.mappers.PharmacyBranchMapperImpl;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.junit.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.mockito.Mock;


public class MappingtTests {
    TestData testData = new TestData();
    @InjectMocks
    PharmacyBranchMapperImpl pharmacyBranchMapper;
    @Mock
    PharmacyService pharmacyService;
    @Mock
    PharmacyBranchService pharmacyBranchService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldMapPharmacyBranchDtoToPharmacyBranchWhenDtoIsCorrect() {
        //given
        PharmacyBranch testedBranch = testData.pharmacyBranches.get(0);
        given(pharmacyService.getPharmacyId(any())).willReturn(testedBranch.getId());
        //when
        PharmacyBranch mappedPharmacyBranch = pharmacyBranchMapper.mapPharmacyBranch(testData.pharmacyBranchDTO);
        //then
        assertEquals(testedBranch, mappedPharmacyBranch);
    }

    @Test
    public void shouldMapUpdatePharmacyBranchDtoToPharmacyBranchWhenDtoIsCorrect() {
        //given
        PharmacyBranch testedBranch = testData.expectedUpdatedPharmacyBranch;
        given(pharmacyService.getPharmacyId(any())).willReturn(testedBranch.getId());
        given(pharmacyBranchService.getPharmacyBranchAddressId(any())).willReturn(testedBranch.getPharmacyBranchAddress().getId());
        //when
        PharmacyBranch mappedPharmacyBranch = pharmacyBranchMapper.mapPharmacyBranchToUpdate(testData.pharmacyBranchDTOToUpdate);
        //then
        assertEquals(testedBranch, mappedPharmacyBranch);
    }
}