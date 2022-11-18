package com.ecommerce.mybookstore.repo;

import com.ecommerce.mybookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
