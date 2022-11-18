package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategory(String category);
}
