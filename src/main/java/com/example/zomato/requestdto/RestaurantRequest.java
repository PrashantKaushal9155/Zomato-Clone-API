package com.example.zomato.requestdto;

import com.example.zomato.enums.DietType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotNull(message = "Name can't be null")
    @Pattern(regexp = "^[A-Z][a-z0-9_]{2,39}$", message = "UserName starts with uppercase and length must be 3-40 characters long")
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9\\s,.-]{10,200}$")
    private String description;
    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    private List<DietType> dietTypes;
}