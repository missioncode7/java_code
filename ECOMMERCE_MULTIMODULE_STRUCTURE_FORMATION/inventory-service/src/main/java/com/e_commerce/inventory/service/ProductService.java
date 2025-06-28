package com.e_commerce.inventory.service;

import com.e_commerce.inventory.dto.ProductDTO;
import com.e_commerce.inventory.entity.Product;
import com.e_commerce.inventory.exception.InventoryProductNotFoundException;
import com.e_commerce.inventory.mapper.ProductMapper;
import com.e_commerce.inventory.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;


    public Product saveProduct(Product product) {
        log.info("Saving product: {}", product);
        return repository.save(product);

    }

    public Optional<Product> getProduct(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new InventoryProductNotFoundException(String.format("Product with id %s not existed in database", id));
        }
        return repository.findById(id);
    }

    public boolean reduceStock(Long productId, int quantity) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent() && product.get().getQuantity() >= quantity) {
            product.get().setQuantity(product.get().getQuantity() - quantity);
            repository.save(product.get());
            return true;
        }
        return false;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> product = repository.findAll();
        return product.stream().map(ProductMapper::toProductDTO).toList();
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product with id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(Long id, Product product) {
        log.info("Updating product with id: {}", id);
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            return ProductMapper.toProductDTO(repository.save(existingProduct));
        }
        throw new InventoryProductNotFoundException(String.format("Product with id %s not existed in database", id));
    }
}
