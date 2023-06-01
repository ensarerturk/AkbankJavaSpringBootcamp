package org.example.service;

import org.example.entity.Country;
import org.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) throws NotFoundException {

        return countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country not found with id: " + id));
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id) throws NotFoundException {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        } else {
            throw new NotFoundException("Country not found with id: " + id);
        }
    }

    public Country updateCountry(Long id, Country country) throws NotFoundException {
        if (countryRepository.existsById(id)) {
            country.setId(id);
            return countryRepository.save(country);
        } else {
            throw new NotFoundException("Country not found with id: " + id);
        }
    }
}
