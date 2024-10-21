package com.example.zomato.requestdto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    @NotNull(message = "Address line 1 can't be null")
    private String addressLine1;

    private String addressLine2;

    private String landmark;

    @NotNull(message = "Area can't be null")
    private String area;

    @NotNull(message = "City can't be null")
    private String city;

    @NotNull(message = "State can't be null")
    private String state;

    @Pattern(regexp = "^\\d{6}$", message = "Pin code must be 6 digits")
    private String pinCode;

    private double latitude;

    private double longitude;
}
