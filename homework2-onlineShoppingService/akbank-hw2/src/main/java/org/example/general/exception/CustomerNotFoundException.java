package org.example.general.exception;

// A custom exception class to be thrown when Customer is not found

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message + " not found.");
    }
}