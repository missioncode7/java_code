package com.e_commerce.mapper;

import com.e_commerce.dto.CartItemDTO;
import com.e_commerce.entity.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {

    public   CartItemDTO  toDto(CartItem cartItem) {
        return CartItemDTO.builder()
                .id(cartItem.getId())
                .productId(cartItem.getProductId())
                .quantity(cartItem.getQuantity())
                .userId(cartItem.getUserId())
                .build();
    }

    public   CartItem toEntity(CartItemDTO cartItemDTO) {
        return CartItem.builder()
                .id(cartItemDTO.getId())
                .quantity(cartItemDTO.getQuantity())
                .userId(cartItemDTO.getUserId())
                .productId(cartItemDTO.getProductId())
                .build();
    }
}
