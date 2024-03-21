package com.pharmacy.Pharmacy;

import com.pharmacy.Pharmacy.model.Pharmacy;
import com.pharmacy.Pharmacy.repository.PharmacyRepository;
import com.pharmacy.Pharmacy.service.PharmacyService;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PharmacyServiceTests {
    @Mock
    PharmacyRepository pharmacyRepository;
    @Mock
    PharmacyService pharmacyService;
    Pharmacy pharmacy;

    @Before
    public void setup() {
        pharmacy = Mockito.mock(Pharmacy.class);
        given(pharmacy.getName()).willReturn("TestPharmacy");
        given(pharmacy.getId()).willReturn(1L);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPharmacyIdWhenPharmacyExists() {
        given(pharmacyRepository.findOneByName("TestPharmacy"))
                .willReturn(Optional.of(pharmacy));
        assertThat(pharmacyService.getPharmacyId("TestPharmacy")).isEqualTo(1L);
    }
}
