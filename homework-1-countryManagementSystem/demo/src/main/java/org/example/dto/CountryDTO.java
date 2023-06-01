package org.example.dto;

import lombok.Getter;
import lombok.Setter;

public record CountryDTO(Long id, String name, String capital, String currency) {
}
