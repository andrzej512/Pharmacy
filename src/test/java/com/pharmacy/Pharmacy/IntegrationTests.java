package com.pharmacy.Pharmacy;
import com.pharmacy.Pharmacy.controller.PharmacyBranchController;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PharmacyBranchController.class)
public class IntegrationTests {
    @Autowired
    MockMvc mvc;
    @MockBean
    PharmacyBranchService pharmacyBranchService;

    @Test
    public void addEmployeeTest() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/pharmacyBranch")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

