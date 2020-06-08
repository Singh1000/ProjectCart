package com.ethoca.shoppingcart.controller;

import com.ethoca.shoppingcart.model.Product;
import com.ethoca.shoppingcart.service.CartService;
import com.ethoca.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/shoppingCart/{shoppingCartId}/products/{productId}/quantity/{quantity}")
    public void addProductToCart(@PathVariable("shoppingCartId") Long shoppingCartId, @PathVariable("productId") Long productId, @PathVariable("quantity") int quantity) {
        cartService.addOrUpdateProduct(shoppingCartId, productId, quantity);
    }

    @DeleteMapping("/shoppingCart/{shoppingCartId}/products/{productId}")
    public void removeProductFromCart(@PathVariable("shoppingCartId") Long shoppingCartId, @PathVariable("productId") Long productId) {
        cartService.removeProduct(shoppingCartId, productId);
    }

    @GetMapping("/shoppingCart/{shoppingCartId}")
    public List<Optional<Product>> getProductsFromCart(@PathVariable("shoppingCartId") Long shoppingCartId) {
        return cartService.getProductsFromCart(shoppingCartId);
    }
}