package org.example.general.exception;

import org.example.general.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/*
 * RESTful is a component class used to provide the general exception handling mechanism of the service.
 * This class handles some types of exceptions that can occur application-wide and generates the appropriate responses.
 * Using exception handler methods, ResponseEntity objects containing exception type-specific messages are returned.
 * */

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found");
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<RestResponse<Object>> handleCommentNotFoundException(CommentNotFoundException ex) {
        RestResponse<Object> response = new RestResponse<>(null, false);
        response.setMessages(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidCommentException.class)
    public ResponseEntity<RestResponse<Object>> handleInvalidCommentException(InvalidCommentException ex) {
        RestResponse<Object> response = new RestResponse<>(null, false);
        response.setMessages(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NameAndPhoneNotMatchException.class)
    public ResponseEntity<RestResponse<Object>> handleNameAndPhoneNotMatchException(NameAndPhoneNotMatchException ex) {
        RestResponse<Object> response = new RestResponse<>(null, false);
        response.setMessages(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<RestResponse<Object>> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        RestResponse<Object> response = new RestResponse<>(null, false);
        response.setMessages(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<RestResponse<Object>> handleProductNotFoundException(ProductNotFoundException ex) {
        RestResponse<Object> response = new RestResponse<>(null, false);
        response.setMessages(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}