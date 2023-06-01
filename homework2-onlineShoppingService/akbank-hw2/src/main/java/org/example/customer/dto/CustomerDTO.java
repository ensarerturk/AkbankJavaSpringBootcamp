package org.example.customer.dto;

import org.example.customer.enums.EnumStatus;

/*
 * Represents a data transfer object named "CustomerDTO". This object is used to transport customer-related data.
 * This object is used to facilitate data communication between different components.
 * */

public record CustomerDTO(Long id,
                          String name,
                          String email,
                          String phoneNumber,
                          EnumStatus status) {
}