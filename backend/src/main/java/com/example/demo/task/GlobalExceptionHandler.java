package com.example.demo.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<TaskResponse> handleNotFound(ResourceNotFoundException resourceNotFoundException)
    {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new TaskResponse(false, resourceNotFoundException.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<TaskResponse> handleBadRequest(IllegalArgumentException illegalArgumentException)
    {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new TaskResponse(false,illegalArgumentException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TaskResponse> handleGeneric(Exception e)
    {
        return  ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new TaskResponse(false, e.getMessage()));
    }
}
