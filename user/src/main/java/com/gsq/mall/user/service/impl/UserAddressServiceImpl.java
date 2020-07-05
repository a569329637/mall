package com.gsq.mall.user.service.impl;

import com.gsq.mall.user.entity.UserAddress;
import com.gsq.mall.user.repository.UserAddressRepository;
import com.gsq.mall.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public UserAddress findById(Long id) {
        return userAddressRepository.findById(id).orElse(null);
    }
}
