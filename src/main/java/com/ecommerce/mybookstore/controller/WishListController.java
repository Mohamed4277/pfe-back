package com.ecommerce.mybookstore.controller;

import com.ecommerce.mybookstore.entity.WishList;
import com.ecommerce.mybookstore.service.WishListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/wish-list")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping()
    public List<WishList> findAllWishList(){
        return wishListService.findAllWishList();
    }

    @GetMapping("/{id}")
    public Optional<WishList> findWishListById(@PathVariable("id") Long id){
        return wishListService.findById(id);
    }

    @PostMapping
    public WishList saveWishList(@RequestBody WishList wishList){
        return wishListService.saveWishList(wishList);
    }

    @PutMapping
    public WishList updateWishList(@RequestBody WishList wishList){
        return wishListService.updateWishList(wishList);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        wishListService.deleteWishList(id);
    }

}
