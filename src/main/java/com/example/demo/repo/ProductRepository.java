package com.example.demo.repo;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE name like %?%", nativeQuery = true)
    List<Product> findByNameLike(@Param("name") String name);
    List<Product> findByCategoryId(Long id);
    List<Product> findByNameIgnoreCaseContaining(String name);
}
