package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.entity.Product;
import com.ecommerce.mybookstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
     productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productRepository.findByNameLike(name);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findByNameIgnoreCaseContaining(String name) {
        return productRepository.findByNameIgnoreCaseContaining(name);
    }


}
