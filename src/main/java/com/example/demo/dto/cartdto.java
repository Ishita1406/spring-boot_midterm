package com.example.demo.dto;

import com.example.demo.model.Products;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class cartdto {
    private Long id;
    private Long userId;
    private String date;
    private Products products;
}
