package com.xyy.dao;


import java.util.List;

import com.xyy.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao {

    @Select(value = "select * from user")
    List<User> findAll();

    @Select(value = "select * from user where user_id=#{id}")
    User findById(int id);

    @Insert("insert into user(username,age) value(#{username},#{age})")
    void insertUser(User user);

    @Insert("insert into user(username,age) value(#{username},#{age})")
    void insertManyUser(User user);


}
