package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private double number;
    private String zipcode;
}
