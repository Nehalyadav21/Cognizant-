package com.example.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void savesAndFindsCountryByCode() {
        countryRepository.save(new Country("DE", "Germany", "Berlin"));

        assertTrue(countryRepository.findById("DE").isPresent());
        assertEquals("Berlin", countryRepository.findById("DE").get().getCapital());
    }

    @Test
    void findsCountryByDerivedQueryMethod() {
        countryRepository.save(new Country("JP", "Japan", "Tokyo"));

        Country found = countryRepository.findByName("Japan");

        assertEquals("JP", found.getCode());
    }
}
