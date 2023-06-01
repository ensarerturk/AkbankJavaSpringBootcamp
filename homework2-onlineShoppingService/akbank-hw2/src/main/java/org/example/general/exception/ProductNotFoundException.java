package org.example.general.exception;

// A custom exception class to be thrown when the product is not found

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long message) {
        super("Product not found with id: " + message);
    }
}
