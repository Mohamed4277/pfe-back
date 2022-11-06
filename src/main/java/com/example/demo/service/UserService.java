package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUserBB();
    List<User> getUsers();
    Optional<User> findUserById(Long id);
    User findByUsername(String userName);
}
