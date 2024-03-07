package com.banana.bananamint.exception;

public class AccountNotfoundException extends GlobalException {
    private static final long serialVersionUID = 2L;

    public AccountNotfoundException() {
    }

    public AccountNotfoundException(String message) {
        super(message);
    }

    public AccountNotfoundException(Long id) {
        super(id);
    }
}
