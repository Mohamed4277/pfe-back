package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategory();
    Optional<Category> findById(Long id);
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    Category findByCategory(String category);
    void deleteCategory(Long id);

}
