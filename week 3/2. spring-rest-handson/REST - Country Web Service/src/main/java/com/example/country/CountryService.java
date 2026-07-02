package com.example.country;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CountryService {

    private final Map<String, Country> countries = new ConcurrentHashMap<>();

    public CountryService() {
        countries.put("IN", new Country("IN", "India", "New Delhi", 1_428_600_000L));
        countries.put("US", new Country("US", "United States", "Washington, D.C.", 339_996_000L));
        countries.put("FR", new Country("FR", "France", "Paris", 68_170_000L));
    }

    public List<Country> findAll() {
        return List.copyOf(countries.values());
    }

    public Optional<Country> findByCode(String code) {
        return Optional.ofNullable(countries.get(code.toUpperCase()));
    }

    public Country save(Country country) {
        countries.put(country.getCode().toUpperCase(), country);
        return country;
    }

    public boolean deleteByCode(String code) {
        return countries.remove(code.toUpperCase()) != null;
    }
}
