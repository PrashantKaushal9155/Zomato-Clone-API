package com.example.zomato.mapper;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.RestaurantResponse;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant mapToRestaurant(RestaurantRequest restaurantRequest, Restaurant restaurant) {
        restaurant.setName(restaurantRequest.getName());
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setEmail(restaurantRequest.getEmail());
        restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
        restaurant.setDietTypes(restaurantRequest.getDietTypes());

        return restaurant;
    }
    public RestaurantResponse mapToRestaurantResponse(Restaurant restaurant){
        RestaurantResponse response = new RestaurantResponse();
        response.setRestaurantId(restaurant.getRestaurantId());
        response.setName(restaurant.getName());
        response.setDescription(restaurant.getDescription());
        response.setEmail(restaurant.getEmail());
        response.setPhoneNumber(restaurant.getPhoneNumber());
        response.setDietTypes(restaurant.getDietTypes());

        return response;
    }
}
