package com.challenge.foro_hub.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ValidacionCreacionTopicoException.class)
    public ResponseEntity<?> handleValidacionCreacionTopico(ValidacionCreacionTopicoException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
