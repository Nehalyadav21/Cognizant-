package com.example.country;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private static final Map<String, Country> COUNTRIES = Map.of(
            "IN", new Country("IN", "India", "New Delhi"),
            "US", new Country("US", "United States", "Washington, D.C."),
            "FR", new Country("FR", "France", "Paris")
    );

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        Country country = COUNTRIES.get(code.toUpperCase());
        return country != null ? ResponseEntity.ok(country) : ResponseEntity.notFound().build();
    }
}
