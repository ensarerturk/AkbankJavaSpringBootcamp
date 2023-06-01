package org.example.general.exception;

// A custom exception class to be thrown when comments are not found

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message) {
        super(message);
    }
}