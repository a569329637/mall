package com.gsq.mall.order.feign;

import com.gsq.mall.order.core.ResponseData;
import com.gsq.mall.user.entity.UserAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mall-user-server")
public interface UserAddressFeignClient {

    @GetMapping("/user_address/{id}")
    ResponseData<UserAddress> findById(@PathVariable("id") Long id);

}
