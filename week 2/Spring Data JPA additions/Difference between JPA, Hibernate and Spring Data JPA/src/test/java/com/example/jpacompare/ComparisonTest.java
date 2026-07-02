package com.example.jpacompare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ComparisonTest {

    @Autowired
    private JpaService jpaService;

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @Transactional
    void allThreeApproachesPersistAndReadTheSameWay() {
        jpaService.save(new Country("DE", "Germany", "Berlin"));
        hibernateService.save(new Country("JP", "Japan", "Tokyo"));
        countryRepository.save(new Country("BR", "Brazil", "Brasília"));

        assertEquals("Berlin", jpaService.findByCode("DE").getCapital());
        assertEquals("Tokyo", hibernateService.findByCode("JP").getCapital());
        assertEquals("Brasília", countryRepository.findById("BR").orElseThrow().getCapital());
    }
}
