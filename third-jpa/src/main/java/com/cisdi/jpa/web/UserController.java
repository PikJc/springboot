package com.cisdi.jpa.web;

import com.cisdi.jpa.dao.UserDao;
import com.cisdi.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 08:41:00
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/add")
    public User add(String name){
        User user = new User();
        user.setName(name);
        user.setAge(new Random().nextInt(100));
        user.setSex(new Random().nextInt(10)%2==0?"男":"女");
        userDao.save(user);
        return user;
    }



}
