package com.gsq.mall.user;

import com.gsq.mall.user.controller.UserController;
import com.gsq.mall.user.core.ResponseData;
import com.gsq.mall.user.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

    @Autowired
    private UserController userController;

    @Test
    public void testFindByIdSuccess() {
        ResponseData<User> userData = userController.findById(1L);
        Assert.assertNotNull(userData);

        User user = userData.getData();
        Assert.assertEquals(1L, user.getUserId().longValue());
        Assert.assertEquals("account1", user.getUsername());
        Assert.assertEquals("nickname1", user.getNickname());
    }

    @Test
    public void testFindByIdFail() {
        ResponseData<User> userData = userController.findById(6L);
        Assert.assertNotNull(userData);

        User user = userData.getData();
        Assert.assertNull(user);
    }

}
