package com.example.zomato.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindRestaurantByIdException extends RuntimeException {
    private final String message;
    @Override
    public String getMessage(){
        return message;
    }
}
