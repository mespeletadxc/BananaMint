package com.banana.bananamint.exception;

public class AccountException extends RuntimeException{
    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(Long accountID) {
        super("Account with id: " + accountID + " not found");
    }
}
