package com.gsq.mall.order.service;

import com.gsq.mall.order.controller.params.CreateOrderParams;
import com.gsq.mall.order.entity.Order;
import org.springframework.data.domain.Page;

public interface OrderService {

    Order createOrder(CreateOrderParams params);

    Order findById(Long id);

    Page<Order> getPage(Long userId, Integer currentPage, Integer pageSize);

}
