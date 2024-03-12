package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.cart;

public interface serviceinterface {
    Product[] getAllProducts();

    cart[] AllProductsinCart();

    User[] Allusers();

    Product getSingleProduct(Long id);

    cart getSingleCart(Long id);

    User getSingleUser(Long id);
    cart deleteCart(Long id);

    cart updateCart(Long id);

    cart postCart(cart a);
}
