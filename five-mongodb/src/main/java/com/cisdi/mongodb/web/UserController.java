package com.cisdi.mongodb.web;

import com.cisdi.mongodb.dao.UserRepository;
import com.cisdi.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月04日 08:37:00
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/save")
    public String save(){
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setAge(new Random().nextInt(100));
//            user.setFirstName("欧阳");
//            user.setLastName("娜娜"+i);
//            user.setId(String.valueOf(i));
//            userRepository.save(user);
//        }
        List<User> name = userRepository.findByFirstName("欧阳");
        name.forEach(v -> System.out.println(v.toString()));
        System.out.println(userRepository.findByLastName("娜娜5").toString());
        return "ok";
    }


}
