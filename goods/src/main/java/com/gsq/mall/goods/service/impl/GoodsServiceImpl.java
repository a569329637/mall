package com.gsq.mall.goods.service.impl;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.goods.repository.GoodsRepository;
import com.gsq.mall.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods findById(Long id) {
        return goodsRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStock(Long goodsId, Integer count) {
        Goods goods = goodsRepository.findById(goodsId).orElse(null);
        if (goods != null && goods.getCount() >= count) {
            goods.setCount(goods.getCount() - count);
            goodsRepository.save(goods);
        } else {
            throw new RuntimeException("goods not found or goods count not enough");
        }
    }
}
