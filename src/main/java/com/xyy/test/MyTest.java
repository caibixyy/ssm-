package com.xyy.test;

import com.xyy.bean.User;
import com.xyy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author BieHongLi
 * @version 创建时间：2017年3月28日 下午9:13:18
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
public class MyTest {

    /*@Autowired
    private UserService userServiceImpl;*/

    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userServiceImpl = (UserService) ac.getBean("userServiceImpl");

    @Test
    public void findAll(){
        System.out.println(userServiceImpl.findAll());
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("田七");
        user.setAge(20);
        userServiceImpl.insertUser(user);
        System.out.println(userServiceImpl.findAll());
    }

    @Test
    public void txMmanager_required(){
        User user = new User();
        user.setUsername("张三");
        user.setAge(20);
        userServiceImpl.insertUser(user);
    }
    @Test
    public void txMmanager_qeruires_new(){
        User user = new User();
        user.setUsername("李四");
        user.setAge(20);
        userServiceImpl.insertManyUser(user);
    }
    @Test
    public void txMmanager_nested(){
        User user = new User();
        user.setUsername("王五");
        user.setAge(20);
        userServiceImpl.insertManyUser(user);
    }
}