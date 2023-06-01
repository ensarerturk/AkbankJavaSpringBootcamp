package org.example.customer.dto;

// This object carries the information required for customer deletion.

public record CustomerDeleteDTO(String name,
                                String phoneNumber) {
}