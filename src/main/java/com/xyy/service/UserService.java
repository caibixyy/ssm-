package com.xyy.service;

import com.xyy.bean.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
public interface UserService {

   List<User> findAll();

   User findById(int id);

   void insertUser(User user);

   void insertManyUser(User user);
}
