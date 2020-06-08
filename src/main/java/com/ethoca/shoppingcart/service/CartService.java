package com.ethoca.shoppingcart.service;

import com.ethoca.shoppingcart.exception.ProductNotInStockException;
import com.ethoca.shoppingcart.exception.ResourceNotFoundException;
import com.ethoca.shoppingcart.model.Cart;
import com.ethoca.shoppingcart.model.Product;
import com.ethoca.shoppingcart.repository.CartRepository;
import com.ethoca.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    private CartRepository cartRepository;
    private  ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void addOrUpdateProduct(Long cartId, Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product being added to the cart is not found!"));
        if(product.getQuantity() < quantity) {
           throw new ProductNotInStockException();
        }

        Optional<Cart> cart = cartRepository.findById(cartId);

        if(cart.isPresent()) {
            Cart existingCart = cart.get();
            Map<Long, Integer>  mapOfProductIdAndQuantity = existingCart.getMapOfProductIdAndQuantity();
            mapOfProductIdAndQuantity.put(productId, quantity);
            existingCart.setMapOfProductIdAndQuantity(mapOfProductIdAndQuantity);
            cartRepository.save(existingCart);
        } else {
            Cart newCart = new Cart();
            Map<Long, Integer>  mapOfProductIdAndQuantity = new HashMap<>();
            mapOfProductIdAndQuantity.put(productId, quantity);
            newCart.setMapOfProductIdAndQuantity(mapOfProductIdAndQuantity);
            cartRepository.save(newCart);
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
    }

    public void removeProduct(Long cartId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product being added to the cart is not found!"));
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Shopping cart does not exist"));

        Map<Long, Integer> mapOfProductIdAndQuantity = cart.getMapOfProductIdAndQuantity();

        if(mapOfProductIdAndQuantity.containsKey(productId)){
            product.setQuantity(product.getQuantity()+mapOfProductIdAndQuantity.get(productId));
            mapOfProductIdAndQuantity.remove(productId);
        } else {
            throw new ResourceNotFoundException("The product you are trying to remove does not exist in the cart");
        }
        cart.setMapOfProductIdAndQuantity(mapOfProductIdAndQuantity);
        productRepository.save(product);
        cartRepository.save(cart);
    }

    public List<Optional<Product>> getProductsFromCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Shopping cart does not exist"));
        List<Optional<Product>> products = new ArrayList<>();
        cart.getMapOfProductIdAndQuantity().keySet().forEach(productId -> products.add(productRepository.findById(productId)));
        return products;
    }
}
