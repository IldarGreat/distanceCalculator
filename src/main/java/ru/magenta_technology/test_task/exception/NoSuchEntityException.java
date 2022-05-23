package ru.magenta_technology.test_task.exception;

public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException() {
        super();
    }

    public NoSuchEntityException(String message) {
        super(message);
    }

}
