package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Runs automatically on application start and demonstrates the quick,
 * boilerplate-free usage of Spring Data JPA: save, findAll, findById,
 * and a derived query method.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;

    public DataLoader(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) {
        countryRepository.save(new Country("IN", "India", "New Delhi"));
        countryRepository.save(new Country("US", "United States", "Washington, D.C."));
        countryRepository.save(new Country("FR", "France", "Paris"));

        System.out.println("---- All countries ----");
        List<Country> all = countryRepository.findAll();
        all.forEach(System.out::println);

        System.out.println("---- Find by id (code) 'IN' ----");
        countryRepository.findById("IN").ifPresent(System.out::println);

        System.out.println("---- Find by derived query method (name = 'France') ----");
        System.out.println(countryRepository.findByName("France"));
    }
}
