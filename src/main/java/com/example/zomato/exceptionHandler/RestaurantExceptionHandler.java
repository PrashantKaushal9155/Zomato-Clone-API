package com.example.zomato.exceptionHandler;

import com.example.zomato.exception.FindRestaurantByIdException;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class RestaurantExceptionHandler {
    private final AppResponseBuilder responseBuilder;

    @ExceptionHandler(FindRestaurantByIdException.class)
    public ResponseEntity<ErrorStructure> handleRestaurantNotFoundById(FindRestaurantByIdException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Restaurant not found by Id");
    }
}
