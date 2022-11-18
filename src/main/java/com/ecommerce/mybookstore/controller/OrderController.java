package com.ecommerce.mybookstore.controller;

import com.ecommerce.mybookstore.entity.OrderF;
import com.ecommerce.mybookstore.entity.User;
import com.ecommerce.mybookstore.service.OrderService;
import com.ecommerce.mybookstore.service.ProductOrderService;
import com.ecommerce.mybookstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ProductOrderService productOrderService;

    public OrderController(OrderService orderService, UserService userService, ProductOrderService productOrderService) {
        this.orderService = orderService;
        this.userService = userService;
        this.productOrderService = productOrderService;
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderF>> getAllOrdersByUserId(@PathVariable(value = "userId") Long userId) {

        List<OrderF> order = orderService.findByUserId(userId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}")
    public Long createOrder(@PathVariable(value = "userId") Long userId,
                                              @RequestBody OrderF orderRequest) {

        /*userService.findUserById(userId).ifPresentOrElse(
                value -> {
                    orderRequest.setUser(new User(userId));
                    OrderF saveOrder= orderService.saveOrder(orderRequest);},
                () -> System.out.println("Not found")
        );*/

        orderRequest.setUser(new User(userId));
        OrderF saveOrder= orderService.saveOrder(orderRequest);
        Long userIdsaved=saveOrder.getId();
        return userIdsaved;
    }

    @GetMapping()
    public List<OrderF> findAllOrder(){
        return orderService.findAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<OrderF> findOrderById(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

    @PostMapping
    public OrderF saveOrder(@RequestBody OrderF order){
        return orderService.saveOrder(order);
    }

    @PutMapping
    public OrderF updateOrder(@RequestBody OrderF order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }

}
