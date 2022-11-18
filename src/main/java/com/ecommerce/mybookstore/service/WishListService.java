package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.domain.WishList;

import java.util.List;
import java.util.Optional;

public interface WishListService {
    List<WishList> findAllWishList();
    Optional<WishList> findById(Long id);
    WishList saveWishList(WishList order);
    WishList updateWishList(WishList order);
    void deleteWishList(Long id);
}
