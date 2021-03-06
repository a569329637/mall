package com.gsq.mall.user.controller;

import com.gsq.mall.user.core.ResponseData;
import com.gsq.mall.user.entity.User;
import com.gsq.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseData<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseData<>(user);
    }
}
