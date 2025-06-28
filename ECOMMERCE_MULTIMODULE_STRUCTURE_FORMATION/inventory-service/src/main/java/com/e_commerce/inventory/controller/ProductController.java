package com.e_commerce.inventory.controller;

import com.e_commerce.inventory.dto.ProductDTO;
import com.e_commerce.inventory.entity.Product;

import com.e_commerce.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory/products")
public class ProductController {
    @Autowired
    private ProductService service;

    // URL: http://localhost:8081/inventory/products
    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    // URL: http://localhost:8081/inventory/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return service.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // URL: http://localhost:8081/inventory/products/1/reduce
    @PostMapping("/{id}/reduce")
    public ResponseEntity<String> reduceStock(@PathVariable Long id, @RequestParam int qty) {
        return service.reduceStock(id, qty)
                ? ResponseEntity.ok("Stock reduced")
                : ResponseEntity.badRequest().body("Not enough stock");
    }

    // URL: http://localhost:8081/inventory/products
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll() {

        List<ProductDTO> products = service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    // URL: http://localhost:8081/inventory/products/1
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody Product product){
        return service.updateProduct(id, product);
    }

    // URL: http://localhost:8081/inventory/products/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id) {
        service.deleteProduct(id);

    }
}
