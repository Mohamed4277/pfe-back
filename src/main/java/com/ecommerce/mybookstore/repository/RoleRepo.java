package com.ecommerce.mybookstore.repo;

import com.ecommerce.mybookstore.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
        Role findByName(String name);
        }
