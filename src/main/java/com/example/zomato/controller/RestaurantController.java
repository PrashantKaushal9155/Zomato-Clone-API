package com.example.zomato.controller;

import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.RestaurantResponse;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final AppResponseBuilder responseBuilder;


    @PostMapping("/restaurants/save")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return responseBuilder.success(HttpStatus.CREATED, "Restaurant Created", restaurantResponse);
    }
    @PutMapping("/restaurants/update/{restaurant_id}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> updateRestaurant(@RequestBody RestaurantRequest restaurantRequest, @PathVariable("restaurant_id") String restaurantId){
        RestaurantResponse response = restaurantService.updateRestaurant(restaurantRequest, restaurantId);
        return responseBuilder.success(HttpStatus.OK,"Restaurant Updated", response);
    }
}
