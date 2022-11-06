package com.example.demo.api;

import com.example.demo.domain.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> findAllCategory(){
        return categoryService.findAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> findCategoryById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }

}
