package ru.ildar_technology.task.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ildar_technology.task.exception.custom.JsonExceptionMessage;
import ru.ildar_technology.task.exception.custom.NoSuchTypeException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<JsonExceptionMessage> handleException(RuntimeException exception) {
        JsonExceptionMessage data = new JsonExceptionMessage();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<JsonExceptionMessage> handleException(NoSuchTypeException exception) {
        JsonExceptionMessage data = new JsonExceptionMessage();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
