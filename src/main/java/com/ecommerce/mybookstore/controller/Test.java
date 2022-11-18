package com.ecommerce.mybookstore.controller;


import com.ecommerce.mybookstore.entity.User;
import com.ecommerce.mybookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class Test {

    private final UserService userService;

    @GetMapping("/register")
    public List<User> findAllOrder(){
        return userService.getUsers();
    }

}
