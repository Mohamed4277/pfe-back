package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
