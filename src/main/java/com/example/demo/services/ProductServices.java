package com.example.demo.services;

import com.example.demo.dto.cartdto;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServices implements serviceinterface{
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product[] getAllProducts(){
        ResponseEntity<Product[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products",Product[].class);
        Product[] allProducts = response.getBody();
        return allProducts;
    }

    @Override
    public cart[] AllProductsinCart () {
        ResponseEntity<cart[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts",cart[].class);
        cart[] carts = response.getBody();
        return carts;
    }

    @Override
    public User[] Allusers(){
        ResponseEntity<User[]> response = restTemplate.getForEntity("https://fakestoreapi.com/users",User[].class);
        User[] users = response.getBody();
        return users;
    }


    @Override
    public Product getSingleProduct(Long id) {

        Product fakeStoreProductDto =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                Product.class
        );

        Product product = new Product();
        assert fakeStoreProductDto != null;
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public cart getSingleCart(Long id) {
        cart fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                cart.class
        );
        cart carts = new cart();
        assert fakeStoreProductDto != null;
        carts.setId(fakeStoreProductDto.getId());
        carts.setUserId(fakeStoreProductDto.getUserId());
        carts.setDate(fakeStoreProductDto.getDate());

        return carts;
    }

    @Override
    public User getSingleUser(Long id) {
        User fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/users/" + id,
                User.class
        );
        User user = new User();
        assert fakeStoreProductDto != null;
        user.setId(fakeStoreProductDto.getId());
        user.setAddress(fakeStoreProductDto.getAddress());
        user.setEmail(fakeStoreProductDto.getEmail());
        user.setUsername(fakeStoreProductDto.getUsername());
        user.setPassword(fakeStoreProductDto.getPassword());
        user.setName(fakeStoreProductDto.getName());
        user.setPhone(fakeStoreProductDto.getPhone());
        return user;
    }

    @Override
    public cart deleteCart(Long id) {
        cart delcart = getSingleCart(id);
        restTemplate.delete("https:/fakestoreapi.com/carts/" + id);
        return delcart;
    }

    @Override
    public cart updateCart(Long id) {
        cart carts = getSingleCart(id);
        cartdto newcart = new cartdto();
        newcart.setId(carts.getId());
        newcart.setUserId(carts.getUserId());
        newcart.setDate(carts.getDate());

        restTemplate.put("https:/fakestoreapi.com/carts/" + id, newcart);
        return carts;
    }

    @Override
    public cart postCart(cart a){
        cartdto ncart = new cartdto();
        ncart.setId(a.getId());
        ncart.setUserId(a.getUserId());
        ncart.setDate(a.getDate());
        restTemplate.postForObject("https:/fakestoreapi.com/carts/", ncart, cartdto.class);
        return a;
    }
}
