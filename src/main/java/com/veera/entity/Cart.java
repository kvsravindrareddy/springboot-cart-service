package com.veera.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Cart {
    public Cart() {
        this.products = new ArrayList<>();
    }
    private String userId;
    private List<Product> products;
}
