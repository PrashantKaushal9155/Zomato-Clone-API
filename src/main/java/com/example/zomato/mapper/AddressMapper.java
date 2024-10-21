package com.example.zomato.mapper;

import com.example.zomato.entity.Address;
import com.example.zomato.requestdto.AddressRequest;
import com.example.zomato.responsedto.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setLandmark(addressRequest.getLandmark());
        address.setArea(addressRequest.getArea());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setPinCode(addressRequest.getPinCode());
        address.setLatitude(addressRequest.getLatitude());
        address.setLongitude(addressRequest.getLongitude());

        return address;
    }
    public AddressResponse mapToAddressResponse(Address address) {
        AddressResponse response = new AddressResponse();
        response.setAddressLine1(address.getAddressLine1());
        response.setAddressLine2(address.getAddressLine2());
        response.setLandmark(address.getLandmark());
        response.setArea(address.getArea());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setPinCode(address.getPinCode());
        response.setLatitude(address.getLatitude());
        response.setLongitude(address.getLongitude());

        return response;
    }
}
