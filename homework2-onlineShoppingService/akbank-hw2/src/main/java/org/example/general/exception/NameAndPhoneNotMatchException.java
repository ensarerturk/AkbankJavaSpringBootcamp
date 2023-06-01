package org.example.general.exception;

// A custom exception class to be thrown when phone and name don't match

public class NameAndPhoneNotMatchException extends RuntimeException {
    public NameAndPhoneNotMatchException(String username, String phoneNumber) {
        super(username + " username and phone number " + phoneNumber + " do not match.");
    }
}