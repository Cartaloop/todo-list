package edu.lucasrech.todo_list.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("Valor inválido", "400");
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("Parâmetro inválido", "400");
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

}
