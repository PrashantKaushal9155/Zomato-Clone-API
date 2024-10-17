package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.RestaurantResponse;
import com.example.zomato.util.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }
    public RestaurantResponse saveRestaurant(@Valid RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant()));
        return restaurantMapper.mapToRestaurantResponse(restaurant);
    }
}
