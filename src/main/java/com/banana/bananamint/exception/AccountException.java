package com.banana.bananamint.exception;

import lombok.NoArgsConstructor;

//@NoArgsConstructor
public class AccountException extends RuntimeException{
    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }
}


