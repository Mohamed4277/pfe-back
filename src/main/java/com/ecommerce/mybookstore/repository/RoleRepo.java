package com.ecommerce.mybookstore.repository;

import com.ecommerce.mybookstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
        Role findByName(String name);
        }
