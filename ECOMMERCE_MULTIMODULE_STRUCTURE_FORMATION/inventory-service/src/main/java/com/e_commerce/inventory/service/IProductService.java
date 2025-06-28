package com.e_commerce.inventory.service;

import com.e_commerce.inventory.dto.ProductDTO;
import com.e_commerce.inventory.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public Product saveProduct(Product product);

    public Optional<Product> getProduct(Long id);

    public boolean reduceStock(Long productId, int quantity);

    public List<ProductDTO> getAllProducts();

    public void deleteProduct(Long id);

    public ProductDTO updateProduct(Long id, Product product);
}
