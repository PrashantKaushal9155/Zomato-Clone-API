package com.example.zomato.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorStructure<T> {
    private String message;
    private T rootCause;
    private int status;

    public static ErrorStructure<String> create(HttpStatus status, String message, String rootCause) {
        ErrorStructure<String> errorStructure = new ErrorStructure<>();
        errorStructure.setMessage(message);
        errorStructure.setRootCause(rootCause);
        errorStructure.setStatus(status.value());
        return errorStructure;
    }
}
