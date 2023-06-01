package org.example.dto;

import org.example.entity.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDTO map(Country country);
    List<CountryDTO> map(List<Country> countries);
}
