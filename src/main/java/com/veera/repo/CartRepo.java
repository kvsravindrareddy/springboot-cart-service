package com.veera.repo;

import com.veera.entity.Cart;
import com.veera.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CartRepo {
    private Map<String, Cart> cartMap = new HashMap<>();

    public Cart addToCart(final String userId, final Product product) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        if (!cartMap.containsKey(cart.getUserId())) {
            cart.setProducts(Arrays.asList(product));
            cart = cartMap.put(userId, cart);
        } else {
            cart.setUserId(userId);
            List<Product> products = new ArrayList<>();
            products.addAll(cartMap.get(userId).getProducts());
            products.add(product);
            cart.setProducts(products);
            cart = cartMap.replace(cart.getUserId(), cart);
        }
        System.out.println("-----"+cart);
        return cart;
    }

    public Cart getCart(final String userId) {
        return cartMap.get(userId);
    }

    public Cart deleteProduct(final String userId, final Long productId) {
        Cart cart = cartMap.get(userId);
        List<Product> products = cart.getProducts().stream().filter(product -> !product.getId().equals(productId)).collect(Collectors.toList());
        cart.setProducts(products);
        return cartMap.replace(userId, cart);
    }
}
