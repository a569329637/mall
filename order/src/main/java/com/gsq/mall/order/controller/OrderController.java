package com.gsq.mall.order.controller;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.order.controller.params.CreateOrderParams;
import com.gsq.mall.order.core.ResponseData;
import com.gsq.mall.order.entity.Order;
import com.gsq.mall.order.feign.GoodsFeignClient;
import com.gsq.mall.order.feign.UserAddressFeignClient;
import com.gsq.mall.order.feign.UserFeignClient;
import com.gsq.mall.order.repository.OrderRepository;
import com.gsq.mall.order.service.OrderService;
import com.gsq.mall.user.entity.User;
import com.gsq.mall.user.entity.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseData<Order> createOrder(@RequestBody CreateOrderParams params) {
        Order order = orderService.createOrder(params);
        return new ResponseData<>(order);
    }

    @GetMapping("/{id}")
    public ResponseData<Order> findById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return new ResponseData<>(order);
    }

    @GetMapping
    public ResponseData<Page<Order>> getPage(@RequestParam Long userId,
                               @RequestParam Integer currentPage,
                               @RequestParam Integer pageSize) {
        Page<Order> page = orderService.getPage(userId, currentPage, pageSize);
        return new ResponseData<>(page);
    }
}
