package com.hexagonal.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(final String message) {
        super(message);
    }
    public UserNotFoundException() {
        super("Adhesion not found");
    }
}
