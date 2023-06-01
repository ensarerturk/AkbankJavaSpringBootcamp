package org.example.general.exception;

// A custom exception class to be thrown when comment is invalid

public class InvalidCommentException extends RuntimeException {
    public InvalidCommentException(String message) {
        super(message);
    }
}