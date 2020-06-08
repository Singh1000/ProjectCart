package com.ethoca.shoppingcart.controller;

import com.ethoca.shoppingcart.model.Product;
import com.ethoca.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody @Valid Product product){
        productService.addProduct(product);
    }

    @GetMapping("/products/id/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }
}
