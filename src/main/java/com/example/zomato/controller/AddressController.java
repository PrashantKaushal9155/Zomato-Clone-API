package com.example.zomato.controller;

import com.example.zomato.repository.AddressRepository;
import com.example.zomato.requestdto.AddressRequest;
import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.AddressResponse;
import com.example.zomato.responsedto.RestaurantResponse;
import com.example.zomato.service.AddressService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;
    private AppResponseBuilder responseBuilder;

    @PostMapping("address/add/{restaurant_id}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddressToRestaurant(@RequestBody @Valid AddressRequest addressRequest, @PathVariable("restaurant_id") String restaurantId) {
        AddressResponse addressResponse = addressService.addAddressToRestaurant(addressRequest, restaurantId);
        return responseBuilder.success(HttpStatus.CREATED, "Address Created", addressResponse);
    }
}
