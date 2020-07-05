package com.gsq.mall.user.service.impl;

import com.gsq.mall.user.entity.User;
import com.gsq.mall.user.repository.UserRepository;
import com.gsq.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
