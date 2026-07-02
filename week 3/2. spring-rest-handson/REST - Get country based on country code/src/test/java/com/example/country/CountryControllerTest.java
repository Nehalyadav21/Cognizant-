package com.example.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCountryByCodeReturnsMatch() throws Exception {
        mockMvc.perform(get("/api/countries/FR"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("France"));
    }

    @Test
    void getCountryByUnknownCodeReturns404() throws Exception {
        mockMvc.perform(get("/api/countries/ZZ"))
                .andExpect(status().isNotFound());
    }
}
