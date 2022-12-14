package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE name like %:name% or description like %:name%", nativeQuery = true)
    List<Product> findByNameLike(@Param("name") String name);
    List<Product> findByCategoryId(Long id);
    List<Product> findByNameIgnoreCaseContaining(String name);
}
