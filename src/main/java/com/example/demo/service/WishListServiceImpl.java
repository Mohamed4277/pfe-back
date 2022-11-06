package com.example.demo.service;

import com.example.demo.domain.WishList;
import com.example.demo.repo.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public List<WishList> findAllWishList() {
        return wishListRepository.findAll();
    }

    @Override
    public Optional<WishList> findById(Long id) {
        return wishListRepository.findById(id);
    }

    @Override
    public WishList saveWishList(WishList category) {
        return wishListRepository.save(category);
    }

    @Override
    public WishList updateWishList(WishList category) {
        return wishListRepository.save(category);
    }

    @Override
    public void deleteWishList(Long id) {
        wishListRepository.deleteById(id);
    }
}
