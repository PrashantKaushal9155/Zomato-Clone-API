package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.FindRestaurantByIdException;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.RestaurantResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantResponse saveRestaurant(@Valid RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant()));
        return restaurantMapper.mapToRestaurantResponse(restaurant);
    }

    public RestaurantResponse updateRestaurant(RestaurantRequest restaurantRequest, String restaurantId) {
return restaurantRepository.findById(restaurantId)
        .map(exRestaurant -> {
            restaurantMapper.mapToRestaurant(restaurantRequest, exRestaurant);
                            exRestaurant = restaurantRepository.save(exRestaurant);
                            return restaurantMapper.mapToRestaurantResponse(exRestaurant);
        })
        .orElseThrow(() -> new FindRestaurantByIdException("Failed to update the restaurant"));
    }
}
