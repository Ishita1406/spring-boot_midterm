package com.example.demo.dto;

import com.example.demo.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter

public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}
