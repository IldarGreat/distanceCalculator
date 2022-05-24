package ru.ildar_technology.task.exception;

public class NoSuchTypeException extends RuntimeException{
    public NoSuchTypeException() {
        super();
    }

    public NoSuchTypeException(String message) {
        super(message);
    }
}
