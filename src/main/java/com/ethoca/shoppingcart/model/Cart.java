package com.ethoca.shoppingcart.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private Map<Long, Integer> mapOfProductIdAndQuantity = new HashMap<>();

    public Cart() {
    }

    public Map<Long, Integer> getMapOfProductIdAndQuantity() {
        return mapOfProductIdAndQuantity;
    }

    public void setMapOfProductIdAndQuantity(Map<Long, Integer> mapOfProductIdAndQuantity) {
        this.mapOfProductIdAndQuantity = mapOfProductIdAndQuantity;
    }

    public Cart(Map<Long, Integer> mapOfProductIdAndQuantity) {
        this.mapOfProductIdAndQuantity = mapOfProductIdAndQuantity;
    }
}