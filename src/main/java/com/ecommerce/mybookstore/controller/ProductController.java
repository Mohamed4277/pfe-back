package com.ecommerce.mybookstore.controller;

import com.ecommerce.mybookstore.entity.Category;
import com.ecommerce.mybookstore.entity.Product;
import com.ecommerce.mybookstore.service.CategoryService;
import com.ecommerce.mybookstore.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/search")
    public List<Product> findByNameLike(@RequestParam("name") String name ){
        return productService.findByNameIgnoreCaseContaining(name);
    }

    @GetMapping("/category/{productCategory}")
    public List<Product> findByCategory(@PathVariable("productCategory") String productCategory ){
        Category category=categoryService.findByCategory(productCategory);
        //return category.getId();
        return productService.findByCategoryId(category.getId());
    }

    @GetMapping
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

}
