package com.divateam.digames.advice;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        List<Map<String, String>> errors = new ArrayList<>();

        exception.getFieldErrors().forEach(error -> {
            Map<String, String> field = new LinkedHashMap<>();
            field.put("field", error.getField());
            field.put("reason", error.getDefaultMessage());
            errors.add(field);
        });
// OU
/*
        for (FieldError error : exception.getFieldErrors()) {
            Map<String, String> field = new LinkedHashMap<>();
            field.put("field", error.getField());
            field.put("reason", error.getDefaultMessage());
            errors.add(field);
        }
*/
        problemDetail.setDetail("Teste");
        problemDetail.setProperty("errors", errors);

        return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
    }
}
