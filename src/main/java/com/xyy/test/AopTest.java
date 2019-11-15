package com.xyy.test;

import com.xyy.service.UserService;
import com.xyy.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void test1(){
        System.out.println(userServiceImpl.findAll());
    }


}
