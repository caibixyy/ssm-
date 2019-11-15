package com.xyy.controller;

import com.xyy.bean.User;
import com.xyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> findAll(){
        List<User> userList = userService.findAll();
        for(User u:userList) {
        	 System.out.print(u);
        }
        return userList;
    }

    @GetMapping("/testUrl")
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> all = userService.findAll();
        System.out.println(all);
        modelAndView.setViewName("success");
        //modelAndView.addObject("model",all);
        return modelAndView;
    }

    @RequestMapping("/findById/{user_id}")
    @ResponseBody
    public User findById(@PathVariable("user_id") int user_id){
        User user = userService.findById(user_id);
        System.out.println(user);
        return user;
    }
}
