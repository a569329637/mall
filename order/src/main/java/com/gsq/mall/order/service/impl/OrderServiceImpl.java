package com.gsq.mall.order.service.impl;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.order.controller.params.CreateOrderParams;
import com.gsq.mall.order.core.AppException;
import com.gsq.mall.order.core.ResponseData;
import com.gsq.mall.order.entity.Order;
import com.gsq.mall.order.enums.DeletedEnum;
import com.gsq.mall.order.enums.LogisticsStatusEnum;
import com.gsq.mall.order.enums.OrderStatusEnum;
import com.gsq.mall.order.enums.ResultEnum;
import com.gsq.mall.order.feign.GoodsFeignClient;
import com.gsq.mall.order.feign.UserAddressFeignClient;
import com.gsq.mall.order.feign.UserFeignClient;
import com.gsq.mall.order.repository.OrderRepository;
import com.gsq.mall.order.service.OrderService;
import com.gsq.mall.user.entity.User;
import com.gsq.mall.user.entity.UserAddress;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private GoodsFeignClient goodsFeignClient;
    @Autowired
    private UserAddressFeignClient userAddressFeignClient;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public Order createOrder(CreateOrderParams params) {
        ResponseData<User> userData = userFeignClient.findById(params.getUserId());
        User user = userData.getData();
        if (user == null) {
            throw new AppException(ResultEnum.USER_NOT_FOUND);
        }
        ResponseData<UserAddress> userAddressData = userAddressFeignClient.findById(params.getUserAddressId());
        UserAddress userAddress = userAddressData.getData();
        if (userAddress == null) {
            throw new AppException(ResultEnum.USER_ADDRESS_NOT_FOUND);
        }
        ResponseData<Goods> goodsData = goodsFeignClient.findById(params.getGoodsId());
        Goods goods = goodsData.getData();
        if (goods == null) {
            throw new AppException(ResultEnum.GOODS_NOT_FOUND);
        }
        // check goods stock
        if (goods.getCount() < params.getGoodsCount()) {
            throw new AppException(ResultEnum.GOODS_COUNT_NOT_ENOUGH);
        }

        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setStatus(OrderStatusEnum.UNPAID.getStatus());
        order.setDeleted(DeletedEnum.NO.getStatus());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());

        order.setLogisticsStatus(LogisticsStatusEnum.INIT.getStatus());
        order.setLogisticsNumber(RandomStringUtils.randomAlphanumeric(10));

        order.setUserAddressId(userAddress.getUserAddressId());
        order.setUsername(userAddress.getUserName());
        order.setUserMobile(userAddress.getMobile());
        order.setUserCountry(userAddress.getCountry());
        order.setUserProvince(userAddress.getProvince());
        order.setUserCity(userAddress.getCity());
        order.setUserAddressDetail(userAddress.getDetail());

        order.setGoodsId(goods.getGoodsId());
        order.setGoodsTitle(goods.getTitle());
        order.setGoodsDescription(goods.getDescription());
        order.setGoodsPrice(BigDecimal.valueOf(params.getGoodsCount()).multiply(goods.getPrice()));
        order.setGoodsCount(params.getGoodsCount());
        order = orderRepository.save(order);

        ResponseData responseData = goodsFeignClient.updateStock(params.getGoodsId(), params.getGoodsCount());
        if (!Objects.equals(responseData.getCode(), ResultEnum.SUCCESS.getCode())) {
            throw new AppException(ResultEnum.GOODS_COUNT_NOT_ENOUGH);
        }
        return order;
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public Page<Order> getPage(Long userId, Integer currentPage, Integer pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return orderRepository.findAllByUserId(userId, pageable);
    }
}
