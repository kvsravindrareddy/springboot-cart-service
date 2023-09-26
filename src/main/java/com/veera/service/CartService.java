package com.veera.service;

import com.veera.entity.Cart;
import com.veera.entity.Product;
import com.veera.repo.CartRepo;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepo cartRepo;

    public CartService(final CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public Cart deleteProductFromCart(final String userId, final Long id) {
        return cartRepo.deleteProduct(userId, id);
    }

    public Cart addProduct(final String userId, final Product product) {
        return cartRepo.addToCart(userId, product);
    }

    public Cart getCart(String userId) {
        return cartRepo.getCart(userId);
    }
}
