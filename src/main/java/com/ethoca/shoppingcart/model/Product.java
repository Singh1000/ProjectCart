package com.ethoca.shoppingcart.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 256)
    @NotNull(message = "Product name is required.")
    private String name;

    private Double price;

    private int quantity;

    public Product() {
    }

    @URL
    private String pictureUrl;

    public Product(String name, Double price, String pictureUrl, int quantity) {
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}