package com.ethoca.shoppingcart.service;

import com.ethoca.shoppingcart.exception.ResourceNotFoundException;
import com.ethoca.shoppingcart.model.Product;
import com.ethoca.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long productId) {
       return productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
