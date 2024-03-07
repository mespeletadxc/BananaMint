package com.banana.bananamint.exception;

public class GoalException extends RuntimeException {
    protected static final long serialVersionUID = 1L;

    public GoalException() {
    }

    public GoalException(String message) {
        super(message);
    }

    public GoalException(Long id) {
        super("GlobalException for element with id: " + id);
    }

}
