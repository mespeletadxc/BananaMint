package com.banana.bananamint.exception;

public class AccountNotfoundException extends GoalException{
    protected static final long serialVersionUID = 2L;

    public AccountNotfoundException() {
        super("Account not found");
    }

    public AccountNotfoundException(String message) {
        super(message);
    }

    public AccountNotfoundException(Long accountId) {
        super("Account with id: " + accountId + " not found");
    }
}
