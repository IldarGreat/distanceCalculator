package ru.magenta_technology.test_task.exception;

public class NoSuchTypeException extends RuntimeException{
    public NoSuchTypeException() {
        super();
    }

    public NoSuchTypeException(String message) {
        super(message);
    }
}
