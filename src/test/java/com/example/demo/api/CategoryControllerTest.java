package com.example.demo.api;

import com.example.demo.domain.Category;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.service.CategoryServiceImpl;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private CategoryServiceImpl categoryService;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    private UserService userService;


    @Test
    @WithMockUser(value = "spring")
    void findAllCategory() throws Exception {
        List<Category> listCategory=new ArrayList<>();
        listCategory.add(new Category(1L,"Mathematiques"));
        listCategory.add(new Category(2L,"Computing"));
        listCategory.add(new Category(3L,"Physics"));

        Mockito.when(categoryRepository.findAll()).thenReturn(listCategory);
        Mockito.when(categoryService.findAllCategory()).thenReturn(listCategory);

        String url="/api/category";

        mockMvc.perform(get(url)).andExpect(status().isOk());



    }


}