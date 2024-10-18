package com.example.zomato.exceptionHandler;

import com.example.zomato.util.ErrorStructure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorBody> errors = ex.getAllErrors().stream()
                .map(error -> {
                    FieldError fieldError = (FieldError) error;
                    return new ErrorBody(
                            fieldError.getField(),
                            fieldError.getDefaultMessage(),
                            fieldError.getRejectedValue()
                    );
                }).toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorStructure.create(HttpStatus.BAD_REQUEST,"Invalid Request", errors.toString()));
    }

    @AllArgsConstructor
    @Getter
    private class ErrorBody {
        String fieldName;
        String message;
        Object rejectedValue;
    }
}
