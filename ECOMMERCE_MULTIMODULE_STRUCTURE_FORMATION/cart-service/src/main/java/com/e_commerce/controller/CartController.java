package com.e_commerce.controller;


import com.e_commerce.dto.CartItemDTO;
import com.e_commerce.entity.CartItem;
import com.e_commerce.service.CartServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl service;

    // Url: http://localhost:8082/cart
    @PostMapping
    public CartItemDTO add(@RequestBody CartItem item) {
        return service.add(item);
    }

    // Url: http://localhost:8082/cart/{userId}
    @GetMapping("/{userId}")
    public List<CartItem> get(@PathVariable String userId) {
        return service.getUserCart(userId);
    }
}
