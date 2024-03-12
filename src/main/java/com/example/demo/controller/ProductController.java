package com.example.demo.controller;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.cart;
import com.example.demo.services.ProductServices;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductServices productServices;
    public ProductController(ProductServices productServices){
        this.productServices= productServices;
    }

    @GetMapping("/products/")
    public Product[] getAllProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping("/carts/")
    public cart[] AllProductsinCart() {
        return productServices.AllProductsinCart();
    }

    @GetMapping("/users/")
    public User[] Allusers() {
        return productServices.Allusers();
    }
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id")Long id) {
        return productServices.getSingleProduct(id);
    }

    @GetMapping("/carts/{id}")
    public cart getSingleCart(@PathVariable("id")Long id) {
        return productServices.getSingleCart(id);
    }

    @GetMapping("users/{id}")
    public User getAllUsers(@PathVariable("id")Long id) {
        return productServices.getSingleUser(id);
    }

    @DeleteMapping("carts/{id}")
    public cart deleteCart(@PathVariable("id") Long id){
        return productServices.deleteCart(id);
    }

    @PatchMapping("carts/{id}")
    public cart updateCart(@PathVariable("id")Long id) {
        return productServices.updateCart(id);
    }

    @PostMapping("/carts")
    public cart postProduct(@RequestBody cart a){
        return productServices.postCart(a);
    }
}
