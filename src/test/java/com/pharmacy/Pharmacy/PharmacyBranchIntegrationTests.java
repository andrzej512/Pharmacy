package com.pharmacy.Pharmacy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PharmacyBranchIntegrationTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    TestData testData;

    @Test
    public void shouldReturnAllPharmacyBranches() throws Exception {
        //given
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pharmacyBranch"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        //when
        List<PharmacyBranchDTO> allPharmacyBranches = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<List<PharmacyBranchDTO>>() {
                });
        //then
        assertEquals(testData.createPharmacyBranchDTO(), allPharmacyBranches.get(0));
    }
}