package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.repo.CategoryRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    private CategoryServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest=new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void findAllCategory() {
        // when
        underTest.findAllCategory();
        //then
        verify(categoryRepository).findAll();
    }

    @Test
    void saveCategory(){
        // given
        Category category=new Category(1L,"Mathematiques");
        // when
        underTest.saveCategory(category);
        ArgumentCaptor<Category> categoryArgumentCaptor=ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        Category capturedCategory=categoryArgumentCaptor.getValue();

        assertThat(capturedCategory).isEqualTo(category);
    }


}