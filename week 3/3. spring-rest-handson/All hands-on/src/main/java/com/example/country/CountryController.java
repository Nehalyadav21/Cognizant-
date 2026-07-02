package com.example.country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        return countryService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country createCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country country) {
        if (countryService.findByCode(code).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        country.setCode(code);
        return ResponseEntity.ok(countryService.save(country));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        boolean removed = countryService.deleteByCode(code);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
