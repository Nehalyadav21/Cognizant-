package com.example.jpacompare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Saves and reads the SAME data through all three layers, so you can see
 * the amount of code each one takes for an identical result:
 *   1. Plain JPA (EntityManager)      - the specification
 *   2. Native Hibernate (Session)     - the provider implementing JPA
 *   3. Spring Data JPA (Repository)   - a framework built on top of both
 */
@Component
public class ComparisonRunner implements CommandLineRunner {

    private final JpaService jpaService;
    private final HibernateService hibernateService;
    private final CountryRepository countryRepository;

    public ComparisonRunner(JpaService jpaService,
                             HibernateService hibernateService,
                             CountryRepository countryRepository) {
        this.jpaService = jpaService;
        this.hibernateService = hibernateService;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println("==== 1. Plain JPA (EntityManager) ====");
        jpaService.save(new Country("IN", "India", "New Delhi"));
        System.out.println("findByCode: " + jpaService.findByCode("IN"));
        System.out.println("findAll:    " + jpaService.findAll());

        System.out.println("\n==== 2. Native Hibernate (Session) ====");
        hibernateService.save(new Country("US", "United States", "Washington, D.C."));
        System.out.println("findByCode: " + hibernateService.findByCode("US"));
        System.out.println("findAll:    " + hibernateService.findAll());

        System.out.println("\n==== 3. Spring Data JPA (Repository) ====");
        countryRepository.save(new Country("FR", "France", "Paris"));
        System.out.println("findByCode: " + countryRepository.findById("FR").orElse(null));
        System.out.println("findAll:    " + countryRepository.findAll());
    }
}
