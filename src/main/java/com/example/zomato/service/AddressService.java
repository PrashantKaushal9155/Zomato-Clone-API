package com.example.zomato.service;

import com.example.zomato.entity.Address;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.FindRestaurantByIdException;
import com.example.zomato.mapper.AddressMapper;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.AddressRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdto.AddressRequest;
import com.example.zomato.requestdto.RestaurantRequest;
import com.example.zomato.responsedto.AddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;
    private RestaurantRepository restaurantRepository;
    private RestaurantMapper restaurantMapper;

    public AddressResponse addAddressToRestaurant(@Valid AddressRequest addressRequest, String restaurantId) {
       return restaurantRepository.findById(restaurantId)
               .map(restaurant -> {
                   Address address = addressMapper.mapToAddress(addressRequest, new Address());
                   restaurant.setAddress(address);
                   restaurantRepository.save(restaurant);
                   return addressMapper.mapToAddressResponse(address);
               })
               .orElseThrow(() -> new FindRestaurantByIdException("Restaurant not found by this Id"));
    }
}
