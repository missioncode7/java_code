package com.e_commerce.service;

import com.e_commerce.dto.CartItemDTO;
import com.e_commerce.entity.CartItem;

import java.util.List;

public interface ICartService {

    public CartItemDTO add(CartItem item);

    public List<CartItem> getUserCart(String userId);
}
