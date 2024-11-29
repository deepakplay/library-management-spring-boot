package org.myproj.libarrymanagementminor.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> requestValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError fr : ex.getBindingResult().getFieldErrors()) {
            errorMap.put(fr.getField(), fr.getDefaultMessage());
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> typeValidation(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errorMap = new HashMap<>();
        String parameterName = ex.getName();

        errorMap.put("error", "Invalid value for parameter: " + parameterName);
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericExceptions(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();

        logger.error("Global Exception occurred", ex);
        errorMap.put("error", "Internal server error happened");

        return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, String>> NotFoundExceptions(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "Invalid URL!");
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }
}
