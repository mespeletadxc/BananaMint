package com.banana.bananamint.exception;

public class CustomerException extends RuntimeException{
    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(Long customerId) {
        super("Customer with id: " + customerId + " not found");
    }
}
