package com.example.zomato.responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String area;
    private String city;
    private String state;
    private String pinCode;
    private double latitude;
    private double longitude;
}
