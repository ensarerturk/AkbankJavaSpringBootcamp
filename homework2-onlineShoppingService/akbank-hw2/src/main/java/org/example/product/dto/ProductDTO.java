package org.example.product.dto;

/*
 * It is used to move the data of a product named "Product".
 * */
public record ProductDTO(Long id,
                         String name,
                         double price,
                         String description) {
}
