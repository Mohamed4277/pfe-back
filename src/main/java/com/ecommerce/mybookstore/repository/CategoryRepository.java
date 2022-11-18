package com.ecommerce.mybookstore.repo;

import com.ecommerce.mybookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategory(String category);
}
