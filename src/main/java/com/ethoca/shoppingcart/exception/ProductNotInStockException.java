package com.ethoca.shoppingcart.exception;

public class ProductNotInStockException extends RuntimeException {
    public ProductNotInStockException() {
        super("Required number of products not in stock");
    };
}
