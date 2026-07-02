package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA gives us a full CRUD + query API for Country just by
 * extending JpaRepository — no implementation code required.
 */
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByName(String name);
}
