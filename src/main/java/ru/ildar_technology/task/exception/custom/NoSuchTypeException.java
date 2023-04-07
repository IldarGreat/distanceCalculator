package ru.ildar_technology.task.exception.custom;

public class NoSuchTypeException extends RuntimeException{

    public NoSuchTypeException(String message) {
        super(message);
    }
}
