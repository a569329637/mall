package com.gsq.mall.goods.controller;

import com.gsq.mall.goods.core.ResponseData;
import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{id}")
    public ResponseData<Goods> findById(@PathVariable Long id) {
        Goods goods = goodsService.findById(id);
        return new ResponseData<>(goods);
    }

    @PostMapping("/{id}/update_stock")
    public ResponseData updateStock(@PathVariable Long id,
                                    @RequestParam Integer count) {
        goodsService.updateStock(id, count);
        return new ResponseData<>();
    }
}
