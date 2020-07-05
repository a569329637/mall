package com.gsq.mall.user.controller;

import com.gsq.mall.user.core.ResponseData;
import com.gsq.mall.user.entity.UserAddress;
import com.gsq.mall.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user_address")
@RestController
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/{id}")
    public ResponseData<UserAddress> findById(@PathVariable Long id) {
        UserAddress userAddress = userAddressService.findById(id);
        return new ResponseData<>(userAddress);
    }
}

