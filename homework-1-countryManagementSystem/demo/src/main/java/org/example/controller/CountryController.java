package org.example.controller;

import org.example.dto.CountryDTO;
import org.example.dto.CountryMapper;
import org.example.entity.Country;
import org.example.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private CountryService countryService;
    private final CountryMapper countryMapper;

    public CountryController(CountryService countryService, CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        List<CountryDTO> countryDTOList = countryMapper.map(countries);
        return ResponseEntity.ok(countryDTOList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable("id") Long id) {
        Country country = countryService.getCountryById(id);
        CountryDTO countryDTO = countryMapper.map(country);
        return ResponseEntity.ok(countryDTO);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> addCountry(@RequestBody Country country) {
        Country savedCountry = countryService.addCountry(country);
        CountryDTO countryDTO = countryMapper.map(savedCountry);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable("id") Long id, @RequestBody Country country) {
        Country updatedCountry = countryService.updateCountry(id, country);
        CountryDTO countryDTO = countryMapper.map(updatedCountry);
        return ResponseEntity.ok(countryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
