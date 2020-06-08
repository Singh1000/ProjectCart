package com.ethoca.shoppingcart.repository;

import com.ethoca.shoppingcart.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

     Product save(Product product);
}
