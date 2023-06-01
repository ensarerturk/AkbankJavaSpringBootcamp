package org.example.product.dto;

/*
 * It is used to carry the information required for the registration of a new product.
 * */
public record ProductSaveDTO(String name,
                             double price,
                             String description) {
}
