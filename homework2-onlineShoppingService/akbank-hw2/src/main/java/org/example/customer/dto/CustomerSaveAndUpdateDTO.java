package org.example.customer.dto;

import org.example.customer.enums.EnumStatus;

// This object carries the information required for customer save and update.

public record CustomerSaveAndUpdateDTO(String name,
                                       String email,
                                       String phoneNumber,
                                       EnumStatus status) {
}