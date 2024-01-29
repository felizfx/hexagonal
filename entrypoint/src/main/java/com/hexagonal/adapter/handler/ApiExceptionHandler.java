package com.hexagonal.adapter.handler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.hexagonal.adapter.handler.response.ErrorResponse;
import com.hexagonal.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerMethodUserNotFound(UserNotFoundException e, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(System.currentTimeMillis())
                .status(NOT_FOUND.value())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
