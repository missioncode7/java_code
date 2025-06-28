package com.e_commerce.inventory.mapper;

import com.e_commerce.inventory.dto.ProductDTO;
import com.e_commerce.inventory.entity.Product;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product) {
      ProductDTO dto = ProductDTO.builder()
               .id(product.getId())
               .name(product.getName())
               .quantity(product.getQuantity())
               .build();
        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product product = Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .build();
        return product;
    }
}
