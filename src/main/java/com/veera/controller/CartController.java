package com.veera.controller;

import com.veera.entity.Cart;
import com.veera.entity.Product;
import com.veera.service.CartService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(final CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart addProduct(@RequestParam("userId")String userId, @RequestBody Product product) {
        System.out.println("........addedd...");
        return cartService.addProduct(userId, product);
    }

    @DeleteMapping("/product")
    public Cart deleteProductFromCart(@RequestParam("userId")String userId, @RequestParam("id")long id) {
        return cartService.deleteProductFromCart(userId, id);
    }

    @GetMapping
    public Cart getCart(@RequestParam("userId")String userId) {
        return cartService.getCart(userId);
    }
}
