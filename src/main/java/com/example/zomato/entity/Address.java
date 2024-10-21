package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "address_id")
    @GenerateCustomId
    private String addressId;
    @Column(name = "address_line1")
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "area")
    private String area;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "pin_code")
    private String pinCode;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
}
