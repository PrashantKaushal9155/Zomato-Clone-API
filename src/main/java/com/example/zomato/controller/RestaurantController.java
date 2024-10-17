package com.example.zomato.controller;

import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.RestaurantResponse;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${zomato.base_url}")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final AppResponseBuilder responseBuilder;

    public RestaurantController(AppResponseBuilder responseBuilder, RestaurantService restaurantService) {
        this.responseBuilder = responseBuilder;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User Created", restaurantResponse);
    }
}
