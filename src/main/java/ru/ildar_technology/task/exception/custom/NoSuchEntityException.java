package ru.ildar_technology.task.exception.custom;

public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException() {
        super();
    }

    public NoSuchEntityException(String message) {
        super(message);
    }

}
