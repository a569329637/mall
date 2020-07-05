package com.gsq.mall.order.controller;

import com.gsq.mall.order.entity.Order;
import com.gsq.mall.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return this.orderRepository.findById(id);
    }
}
