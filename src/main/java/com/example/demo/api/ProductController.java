package com.example.demo.api;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public List<Product> findByNameLike(@RequestParam String name ){
        return productService.findByNameLike(name);
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
