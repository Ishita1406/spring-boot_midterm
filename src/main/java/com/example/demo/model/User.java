package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private Address address;
    private Long id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
}
