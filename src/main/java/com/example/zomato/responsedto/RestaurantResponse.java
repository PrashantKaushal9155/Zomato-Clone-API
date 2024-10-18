package com.example.zomato.responsedto;

import com.example.zomato.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantResponse {
    private String restaurantId;
    private String name;
    private String description;
    private String phoneNumber;
    private String email;
    private List<DietType> dietTypes;
}
