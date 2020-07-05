package com.gsq.mall.order.feign;

import com.gsq.mall.order.core.ResponseData;
import com.gsq.mall.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mall-user-server")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    ResponseData<User> findById(@PathVariable("id") Long id);

}
