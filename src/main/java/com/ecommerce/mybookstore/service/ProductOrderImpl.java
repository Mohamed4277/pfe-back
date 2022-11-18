package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.entity.OrderF;
import com.ecommerce.mybookstore.entity.ProductOrder;
import com.ecommerce.mybookstore.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderImpl implements ProductOrderService{

    private ProductOrderRepository productOrderRepository;

    public ProductOrderImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public List<ProductOrder> findAllProductOrder() {
        return productOrderRepository.findAll();
    }



    @Override
    public Optional<ProductOrder> findById(Long id) {
        return productOrderRepository.findById(id);
    }

    @Override
    public ProductOrder saveProductOrder(ProductOrder order) {
        return productOrderRepository.save(order);
    }

    @Override
    public ProductOrder updateProductOrder(ProductOrder order) {
        return productOrderRepository.save(order);
    }

    @Override
    public void deleteProductOrder(Long id) {

    }

    @Override
    public Optional<ProductOrder> findByProductOrderId(Long userId) {

        return productOrderRepository.findById(userId);
    }

    @Override
    public List<ProductOrder> findByOrder(OrderF order) {
        return productOrderRepository.findByOrder(order);
    }
}
