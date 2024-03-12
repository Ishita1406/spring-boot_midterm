package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String imageUrl;
}
