package com.gsq.mall.goods.service;

import com.gsq.mall.goods.entity.Goods;

public interface GoodsService {

    Goods findById(Long id);

    void updateStock(Long goodsId, Integer count);

}
