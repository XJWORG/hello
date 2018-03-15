package com.shop.action;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.shop.model.User;
import com.shop.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")  
public class UserActionTest {

    @Resource
    private UserService userService;
    
    @Test
    public void testLogin() {
//        fail("Not yet implemented");
        User user = new User();
        user.setLogin("user");
        user.setName("user");
        user.setPass("user");
//        userService.login(user);
        Assert.isInstanceOf(User.class, userService.login(user));
    }

}
