package com.example.demo.service;

import com.example.demo.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategory();
    Optional<Category> findById(Long id);
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);

}
