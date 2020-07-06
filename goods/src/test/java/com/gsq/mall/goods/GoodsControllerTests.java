package com.gsq.mall.goods;

import com.gsq.mall.goods.controller.GoodsController;
import com.gsq.mall.goods.core.ResponseData;
import com.gsq.mall.goods.entity.Goods;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsControllerTests {

    @Autowired
    private GoodsController goodsController;

    @Test
    public void testFindByIdSuccess() {
        ResponseData<Goods> goodsData = goodsController.findById(1L);
        Assert.assertNotNull(goodsData);

        Goods goods = goodsData.getData();
        Assert.assertEquals(1L, goods.getGoodsId().longValue());
        Assert.assertEquals("mac book pro 1", goods.getTitle());
    }

    @Test
    public void testFindByIdFail() {
        ResponseData<Goods> goodsData = goodsController.findById(6L);
        Assert.assertNotNull(goodsData);

        Goods goods = goodsData.getData();
        Assert.assertNull(goods);
    }

    @Test
    public void testUpdateStockSuccess() {
        ResponseData<Goods> goodsData = goodsController.updateStock(1L, 1);
        Assert.assertNotNull(goodsData);

        Goods goods = goodsData.getData();
        Assert.assertNull(goods);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStockFail() {
        goodsController.updateStock(1L, 1000);
    }

}
