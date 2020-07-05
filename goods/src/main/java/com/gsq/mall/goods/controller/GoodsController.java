package com.gsq.mall.goods.controller;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.goods.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/{id}")
    public Optional<Goods> findById(@PathVariable Long id) {
        return this.goodsRepository.findById(id);
    }
}
