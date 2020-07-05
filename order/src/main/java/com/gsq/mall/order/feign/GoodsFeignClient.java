package com.gsq.mall.order.feign;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.order.core.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mall-goods-server")
public interface GoodsFeignClient {

    @GetMapping("/goods/{id}")
    ResponseData<Goods> findById(@PathVariable("id") Long id);

    @PostMapping("/goods/{id}/update_stock")
    ResponseData updateStock(@PathVariable Long id, @RequestParam Integer count);

}
