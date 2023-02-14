package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.entity.User;
import com.ecommerce.mybookstore.entity.Role;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user, Boolean newUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUserBB();
    List<User> getUsers();
    Optional<User> findUserById(Long id);
    User findByUsername(String userName);
}
