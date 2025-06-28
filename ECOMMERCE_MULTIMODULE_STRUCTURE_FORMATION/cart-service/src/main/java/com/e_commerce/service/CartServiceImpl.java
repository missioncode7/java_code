package com.e_commerce.service;


import com.e_commerce.dto.CartItemDTO;
import com.e_commerce.entity.CartItem;
import com.e_commerce.mapper.CartItemMapper;
import com.e_commerce.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final CartRepository repo;
    private final CartItemMapper mapper;

    public CartItemDTO add(CartItem item) {
        CartItem savedItem=repo.save(item);
        return mapper.toDto(savedItem);
    }

    public List<CartItem> getUserCart(String userId) {
        return repo.findByUserId(userId);
    }
}
