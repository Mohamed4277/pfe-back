package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProduct();
    Optional<Product> findById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> findByNameLike(String name);
    List<Product> findByCategoryId(Long id);
    List<Product> findByNameIgnoreCaseContaining(String name);
}
