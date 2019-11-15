package com.xyy.service.impl;

import com.xyy.bean.User;
import com.xyy.dao.UserDao;
import com.xyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
    /**
     * 支持当前事务，没有则新建,出现异常将回滚事务，如果被捕获将不会回滚
     * @param user
     */
    @Override
    @Transactional
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
    /**
     * 1.标志REQUIRES_NEW会新开启事务，外层事务不会影响内部事务的提交/回滚
     * 2.标志REQUIRES_NEW的内部事务的异常，会影响外部事务的回滚
     * 第二个方法发生错误，因为第一个是单独的事务，所以不会受到影响。
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertManyUser(User user) {
        userDao.insertManyUser(user);
        for (int i = 0; i <4 ; i++) {
            if(i == 2){
                int a = 2/0;
            }
            userDao.insertUser(user);
        }
    }
    /**
     * 如果一个活动的事务存在，运行在一个嵌套的事务中。 如果没有活动事务, 则按REQUIRED属性执行　　
     * @param user
     */
    @Transactional(propagation = Propagation.NESTED)
    public void insertManyUserTwo(User user){
        three(user);
    }
    @Transactional
    public void three(User user){
        userDao.insertUser(user);
    }
}
