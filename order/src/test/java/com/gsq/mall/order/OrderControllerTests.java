package com.gsq.mall.order;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.order.controller.OrderController;
import com.gsq.mall.order.controller.params.CreateOrderParams;
import com.gsq.mall.order.core.AppException;
import com.gsq.mall.order.core.ResponseData;
import com.gsq.mall.order.entity.Order;
import com.gsq.mall.order.feign.GoodsFeignClient;
import com.gsq.mall.order.feign.UserAddressFeignClient;
import com.gsq.mall.order.feign.UserFeignClient;
import com.gsq.mall.user.entity.User;
import com.gsq.mall.user.entity.UserAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTests {

    @Autowired
    private OrderController orderController;
    @MockBean
    private UserFeignClient userFeignClient;
    @MockBean
    private GoodsFeignClient goodsFeignClient;
    @MockBean
    private UserAddressFeignClient userAddressFeignClient;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("account1");
        user.setNickname("nickname1");
        ResponseData<User> userResponseData = new ResponseData<>(user);
        when(userFeignClient.findById(1L)).thenReturn(userResponseData);
        when(userFeignClient.findById(6L)).thenReturn(new ResponseData<>());

        UserAddress userAddress = new UserAddress();
        userAddress.setUserAddressId(6L);
        userAddress.setUserName("guishangquan");
        userAddress.setCountry("China");
        ResponseData<UserAddress> userAddressResponseData = new ResponseData<>(userAddress);
        when(userAddressFeignClient.findById(6L)).thenReturn(userAddressResponseData);
        when(userAddressFeignClient.findById(11L)).thenReturn(new ResponseData<>());

        Goods goods = new Goods();
        goods.setGoodsId(1L);
        goods.setTitle("mac book pro 1");
        goods.setPrice(new BigDecimal("100.00"));
        goods.setCount(10);
        ResponseData<Goods> goodsResponseData = new ResponseData<>(goods);
        when(goodsFeignClient.findById(1L)).thenReturn(goodsResponseData);
        when(goodsFeignClient.findById(6L)).thenReturn(new ResponseData<>());
        when(goodsFeignClient.updateStock(1L, 1)).thenReturn(new ResponseData<>());
    }

    @Test
    public void testCreateOrderSuccess() {
        Order order = handleCreateOrder(1L, 1L, 1, 6L);
        Assert.assertNotNull(order);
        Assert.assertEquals(1L, order.getUserId().longValue());
        Assert.assertEquals(1L, order.getGoodsId().longValue());
        Assert.assertEquals(1, order.getGoodsCount().intValue());
        Assert.assertEquals(6L, order.getUserAddressId().longValue());
        Assert.assertEquals(new BigDecimal("100.00"), order.getGoodsPrice());
    }

    @Test(expected = AppException.class)
    public void testCreateOrderFail1() {
        handleCreateOrder(6L, 1L, 1, 6L);
    }

    @Test(expected = AppException.class)
    public void testCreateOrderFail2() {
        handleCreateOrder(1L, 6L, 1, 6L);
    }

    @Test(expected = AppException.class)
    public void testCreateOrderFail3() {
        handleCreateOrder(1L, 1L, 1, 11L);
    }

    @Test(expected = AppException.class)
    public void testCreateOrderFail4() {
        handleCreateOrder(1L, 1L, 200, 6L);
    }

    @Test
    public void testFindByIdSuccess() {
        Order order = handleCreateOrder(1L, 1L, 1, 6L);

        ResponseData<Order> orderData = orderController.findById(order.getOrderId());
        Assert.assertNotNull(orderData);
        order = orderData.getData();
        Assert.assertNotNull(order);
    }

    @Test
    public void testFindByIdFail() {
        ResponseData<Order> orderData = orderController.findById(1000L);
        Assert.assertNotNull(orderData);
        Order order = orderData.getData();
        Assert.assertNull(order);
    }

    @Test
    public void testGetPage() {
        handleCreateOrder(1L, 1L, 1, 6L);

        ResponseData<Page<Order>> pageData = orderController.getPage(1L, 0, 10);
        Assert.assertNotNull(pageData);
        Page<Order> page = pageData.getData();
        Assert.assertNotNull(page);
        Assert.assertTrue(page.getTotalElements() > 0);
    }

    private Order handleCreateOrder(Long userId, Long goodsId, Integer goodsCount, Long userAddressId) {
        CreateOrderParams params = new CreateOrderParams();
        params.setUserId(userId);
        params.setGoodsId(goodsId);
        params.setGoodsCount(goodsCount);
        params.setUserAddressId(userAddressId);
        ResponseData<Order> orderData = orderController.createOrder(params);
        Assert.assertNotNull(orderData);
        Order order = orderData.getData();
        //System.out.println("order = " + order);
        return order;
    }

}
