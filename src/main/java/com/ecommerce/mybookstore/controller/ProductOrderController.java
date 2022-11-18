package com.ecommerce.mybookstore.api;

import com.ecommerce.mybookstore.domain.ProductOrder;
import com.ecommerce.mybookstore.service.ProductOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/productOrder")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }


    @GetMapping
    public ResponseEntity<List<ProductOrder>> getAllProductOrdersByUserId() {

        List<ProductOrder> order = productOrderService.findAllProductOrder();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveProductOrder(@RequestBody ProductOrder productOrder){
        productOrderService.saveProductOrder(productOrder);
        return new ResponseEntity<>( HttpStatus.OK);
    }





}
