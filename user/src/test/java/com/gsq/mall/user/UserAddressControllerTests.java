package com.gsq.mall.user;

import com.gsq.mall.user.controller.UserAddressController;
import com.gsq.mall.user.core.ResponseData;
import com.gsq.mall.user.entity.UserAddress;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAddressControllerTests {

    @Autowired
    private UserAddressController userAddressController;

    @Test
    public void testFindByIdSuccess() {
        ResponseData<UserAddress> userAddressData = userAddressController.findById(6L);
        Assert.assertNotNull(userAddressData);

        UserAddress userAddress = userAddressData.getData();
        System.out.println("userAddress = " + userAddress);
        Assert.assertEquals(6L, userAddress.getUserAddressId().longValue());
        Assert.assertEquals(1L, userAddress.getUserId().longValue());
        Assert.assertEquals("guishangquan6", userAddress.getUserName());
    }

    @Test
    public void testFindByIdFail() {
        ResponseData<UserAddress> userAddressData = userAddressController.findById(1L);
        Assert.assertNotNull(userAddressData);

        UserAddress userAddress = userAddressData.getData();
        System.out.println("userAddress = " + userAddress);
        Assert.assertNull(userAddress);
    }

}
