package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.domain.Category;
import com.ecommerce.mybookstore.repo.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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